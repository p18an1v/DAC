using APIMemberAPIvirsion08.Models;

namespace APIMemberAPIvirsion08.Services
{
    public interface IMembers
    {
        List<Members> GetAllMember();
        Members GetMember(int id);
        Members Add(Members employee);
        Members Update(int id, Members MembersChanges);
        Members Delete(int Id);
        List<Members> GetAllMemberbyname(string name);
        List<Members> GetAllMemberbyaddress(string address);


    }
}
