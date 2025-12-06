using API_Two_Table.Models;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;

namespace API_Two_Table.Repository
{
    public class AppdbContextRepository : DbContext
    {
        public AppdbContextRepository(DbContextOptions<AppdbContextRepository> options)
             : base(options)
        {
        }

        public DbSet<Employee> Employee { get; set; }
        public DbSet<Department> Department { get; set; }

    }

}
