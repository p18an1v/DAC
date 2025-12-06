using APIMemberAPIvirsion08.Models;
using APIMemberAPIvirsion08.Services;
using Microsoft.AspNetCore.Mvc;

namespace APIMemberAPIvirsion08.Repository
{

    public class MembersRepository : IMembers
    {
        static List<Members> lisMembers = new List<Members>
            {
            new Members{MemberId=1, FirstName="Kirtesh", LastName="Trivedi", Address="Mumbai" },
            new Members{MemberId=2, FirstName="Nitya", LastName="Shah", Address="Vadodara" },
            new Members{MemberId=3, FirstName="Dilip", LastName="Kothari", Address="Banglore" },
            new Members{MemberId=4, FirstName="Atul", LastName="Ambani", Address="Indore" },
            new Members{MemberId=5, FirstName="Swati", LastName="Zaveri", Address="Mumbai" },
            new Members{MemberId=6, FirstName="Rashmi", LastName="Shah", Address="Ahamdabad" },
            };
            public List<Members> GetAllMember()
        {
            return lisMembers;
        }

        public Members GetMember(int id)
        {
            return lisMembers.FirstOrDefault(x => x.MemberId == id);
        }
        public Members Add(Members member)
        {
            member.MemberId = lisMembers.Max(e => e.MemberId) + 1;
            lisMembers.Add(member);
            return member;
        }
        public Members Delete(int Id)
        {
            Members members = lisMembers.FirstOrDefault(e => e.MemberId == Id);
            if (members != null)
            {
                lisMembers.Remove(members);
            }
            return members;
        }
        public Members Update(int id, Members memberChanges)
        {
            Members member = lisMembers.FirstOrDefault(e => e.MemberId == memberChanges.MemberId);
            if (member != null)
            {
                member.FirstName = memberChanges.FirstName;
                member.LastName = memberChanges.LastName;
                member.Address = memberChanges.Address;
            }
            return member;
        }
        public List<Members> GetAllMemberbyname(string name)
        {
            return lisMembers.FindAll((nm) => nm.FirstName == name);

        }
        public List<Members> GetAllMemberbyaddress(string address)
        {
            return lisMembers.FindAll((nm) => nm.Address == address);

        }



    }


}
