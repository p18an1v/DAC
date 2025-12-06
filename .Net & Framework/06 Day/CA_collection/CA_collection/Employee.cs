using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CA_collection
{
    public enum Dept
    {
        HR,
        Payroll,
        IT
    }
    internal class Employee
    {     
            public string Name { get; set; }           
             public int Id { get; set; }
            public string Email { get; set; }
             public Dept? Department { get; set; }
           
    
    public override string ToString()
            {
                return String.Format("{0} {1} {2} {3}",Id , Name, Email, Department);
            }
    }
}
