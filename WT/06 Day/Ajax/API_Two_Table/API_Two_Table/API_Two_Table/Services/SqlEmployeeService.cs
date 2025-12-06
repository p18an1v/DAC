using API_Two_Table.Models;
using API_Two_Table.Repository;
using Microsoft.EntityFrameworkCore;

namespace API_Two_Table.Services
{
    public class SqlEmployeeService : IEmployeeService
    {
        private readonly AppdbContextRepository context;
        public SqlEmployeeService(AppdbContextRepository context)
        {
            this.context = context;
        }
        public Employee Add(Employee employee)
        {
            context.Employee.Add(employee);
            context.SaveChanges();
            return employee;
        }
        public Employee? Delete(int Id)
        {
            Employee? employee = context.Employee.Find(Id);
            if (employee != null)
            {
                context.Employee.Remove(employee);
                context.SaveChanges();
            }
            return employee;
        }

        public IEnumerable<Department> GetAllDepartment()
        {
            return context.Department;
        }
        public IEnumerable<Employee> GetAllEmployee()
        {
            return context.Employee.Include(dpt => dpt.Department).ToList();
        }
        public Employee? GetEmployee(int Id)
        {//context.Employee.Find(Id);
            Employee e = context.Employee.FirstOrDefault(m => m.Id == Id);

            return e;
        }
        public Employee Update(Employee employeeChanges)
        {
            Employee e1 = context.Employee.FirstOrDefault(m => m.Id == employeeChanges.Id);
            context.Entry(e1).State = EntityState.Detached;
            context.Update(employeeChanges);

            context.SaveChanges();
            return employeeChanges;
        }

    }
}
