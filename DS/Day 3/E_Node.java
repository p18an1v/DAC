package Linked_List_Examples;
//We'll take care of employee details within Node.
/*
All these happen on employee ID.
We have details like:
Employee name
Employee ID
Employee gender
Employee salary*/

public class E_Node
{
    //data
    String name,gender;
    int eid;
    float salary;
    //next
    E_Node next;
    E_Node(String name,String gender,int eid,float salary)
    {
        this.name=name;
        this.gender=gender;
        this.eid=eid;
        this.salary=salary;
        this.next=null;
    }
    void print_Node()
    {
        System.out.println("\nID:"+eid+"\tName:"+name+"\tGender:"+gender+"\tSalary:"+salary);
    }
}
