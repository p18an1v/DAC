
using AsynctwotableAPI.Repository;
using AsynctwotableAPI.Services;
using Microsoft.EntityFrameworkCore;

namespace AsynctwotableAPI
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers();

            var b = builder.Configuration.GetConnectionString("BookDatabase");
            builder.Services.AddDbContextPool<AppdbContext>((op) => op.UseSqlServer(b));
            builder.Services.AddTransient<IBookRepository, SqlBookRepository>();

            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseAuthorization();


            app.MapControllers();

            app.Run();
        }
    }
}
