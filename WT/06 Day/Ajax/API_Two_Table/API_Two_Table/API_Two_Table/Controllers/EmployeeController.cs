using API_Two_Table.Models;
using API_Two_Table.Services;
using Microsoft.AspNetCore.Mvc;

namespace API_Two_Table.Controllers
{

    // For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

    namespace APIdemo1.Controllers
    {
        [Route("api/[controller]")]
        [ApiController]
        public class EmployeeController : ControllerBase
        {
            IEmployeeService employeeService;
            public EmployeeController(IEmployeeService employeeService)
            {
                this.employeeService = employeeService;
            }
            // GET: api/<EmployeeController>
            [HttpGet]
            public IEnumerable<Employee> Get()
            {
                return employeeService.GetAllEmployee();
            }

            // GET api/<EmployeeController>/5
            [HttpGet("{id}")]
            public Employee Get(int id)
            {
                return employeeService.GetEmployee(id);
            }


            // POST api/<EmployeeController>201 created
            [HttpPost]
            public ActionResult Post([FromBody] Employee emp)
            {
                employeeService.Add(emp);

                return CreatedAtAction("Get", new { id = emp.Id }, emp);
            }
            [HttpPut("{id}")]
            public void Put(int id, [FromBody] Employee emp)
            {
                if (id != emp.Id)
                {
                    // return BadRequest("The ID in the URL does not match the ID in the request body.");
                }

                Employee e1 = employeeService.GetEmployee(id);
                if (e1 != null)
                {
                    employeeService.Update(emp);
                }
                //  return  NoContent();

            }

            // DELETE api/<EmployeeController>/5 401 nocontent
            [HttpDelete("{id}")]
            public void Delete(int id)
            {
                Employee e1 = employeeService.GetEmployee(id);
                if (e1 != null)
                    employeeService.Delete(id);


            }

            [HttpPost("submit")]
            public IActionResult submit([FromBody] Employee emp)
            {
                employeeService.Add(emp);
                return CreatedAtAction("Get", new { id = emp.Id }, emp);

            }
        }
    }

}
