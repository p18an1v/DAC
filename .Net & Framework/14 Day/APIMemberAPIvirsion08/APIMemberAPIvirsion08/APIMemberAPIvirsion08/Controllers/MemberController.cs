using Microsoft.AspNetCore.Mvc;
using APIMemberAPIvirsion08.Models;
using APIMemberAPIvirsion08.Services;
using System;
using System.Collections;
using System.Collections.Generic;


namespace APIMemberAPIvirsion08.Controllers
{

    // For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860


    [Route("api/[controller]")]
    [ApiController]
    public class MemberController : ControllerBase
    {
        private readonly IMembers member;
        public MemberController(IMembers mem)
        {
            member = mem;

        }
        // GET: api/<MemberController>
        [HttpGet]
        public IEnumerable<Members> Get()
        {
            return member.GetAllMember();
        }

        // GET api/<MemberController>/5
        [HttpGet("{id:int}")]
        public Members Get(int id)
        {
            return member.GetMember(id);
        }
        // POST api/<MemberController>
        [HttpPost]
        public Members Post([FromBody] Members memberpost)
        {
            return member.Add(memberpost);
        }

        [HttpPut("{id}")]
        public Members Put(int id, [FromBody] Members memberput)
        {
            return member.Update(id, memberput);
        }

        // DELETE api/<MemberController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            member.Delete(id);
        }
        [HttpGet("Address/{address}")]
        public IEnumerable<Members> GetAddress(string address)
        {
            return member.GetAllMemberbyaddress(address);
        }
        [HttpGet("{name}")]
        public IEnumerable<Members> Get(string name)
        {
            return member.GetAllMemberbyname(name);
        }


    }
}

        
