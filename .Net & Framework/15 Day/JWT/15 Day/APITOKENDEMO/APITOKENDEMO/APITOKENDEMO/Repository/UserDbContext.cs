using APITOKENDEMO.Models;
using Microsoft.EntityFrameworkCore;
using System;

namespace APITOKENDEMO.Repository
{
    public class UserDbContext:DbContext
    {
        public UserDbContext(DbContextOptions<UserDbContext> options)
             : base(options)
        {
        }
        public DbSet<UserInfo> userInfo { get; set; }

    }

}
