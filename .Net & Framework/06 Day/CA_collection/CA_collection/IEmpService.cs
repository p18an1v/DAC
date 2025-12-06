using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CA_collection
{
    internal interface IEmpService
    {
        Employee GetEmployee(int Id);
        IEnumerable<Employee> GetEmployee(string name);
        IEnumerable<Employee> GetAllEmployee();
        Employee Add(Employee employee);
       Employee Delete(int Id);

    }
}
