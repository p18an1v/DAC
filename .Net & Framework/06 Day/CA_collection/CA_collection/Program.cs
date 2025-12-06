using System.Text.Json;
using System.Text.Json.Serialization;

namespace CA_collection
{
   
    class Program
    {
        static void Main(string[] args)
        {

            IEmpService empService = new EmployeeService();
           Employee e1= empService.Add(new Employee { Name = "Sonam", Department = Dept.IT, Email = "som@CDACtech.com" });
            Console.WriteLine($"{e1} Added in cpllection");
            e1 = empService.Add(new Employee { Name = "Sonam", Department = Dept.HR , Email = "sonam@CDACtech.com" });
            Console.WriteLine($"{e1} Added in cpllection");
            e1 = empService.Delete(3);
            Console.WriteLine($"{e1} Deleted from n collection");

            e1 = empService.GetEmployee(1);
            Console.WriteLine($"record of {e1.Id}==>{e1}");

            IEnumerable<Employee> list = empService.GetEmployee("Sonam");
            Console.WriteLine($"record of with name Sonam");

            foreach (Employee emp in list)
            {
                Console.WriteLine(emp);
            }
            list = empService.GetAllEmployee();
            var options = new JsonSerializerOptions
            {  WriteIndented = true,
                Converters = {new JsonStringEnumConverter
                (JsonNamingPolicy.CamelCase)   }
            };
            foreach (Employee emp in list)
            {
                
                Console.WriteLine(JsonSerializer.Serialize(emp,options));
            }

        }
    }
}


