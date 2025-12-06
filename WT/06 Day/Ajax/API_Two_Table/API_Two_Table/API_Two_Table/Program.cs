
using API_Two_Table.Repository;
using API_Two_Table.Services;
using System.Text.Json.Serialization;

using Microsoft.EntityFrameworkCore;

namespace API_Two_Table
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers().AddJsonOptions(options =>
               options.JsonSerializerOptions.ReferenceHandler =
               ReferenceHandler.IgnoreCycles);
            builder.Services.AddDbContextPool<AppdbContextRepository>(
            options => options.UseSqlServer(builder.Configuration.GetConnectionString("EmployeeDBConnection"))
            );

            builder.Services.AddScoped<IEmployeeService, SqlEmployeeService>();

            builder.Services.AddCors((p) => p.AddDefaultPolicy(
                policy => policy.WithOrigins("*")
                        .AllowAnyHeader()
                    .AllowAnyMethod()
                 ));

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
            app.UseCors();
            app.UseHttpsRedirection();

            app.UseAuthorization();


            app.MapControllers();

            app.Run();
        }
    }
}
