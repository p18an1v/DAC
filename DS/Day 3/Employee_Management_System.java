package Linked_List_Examples;

import java.util.LinkedList;
import java.util.Scanner;

public class Employee_Management_System
{
    public static void main(String[] args) {
        LinkedList<E_Node> list=new LinkedList<>();
        Scanner in=new Scanner(System.in);
        //insert
        String name;String gender;int eid;float salary;
        for(int i=0;i<2;i++) {
            System.out.println("\nEnter name,gender,id,salary for record "+(i+1));
            name = in.next();
            gender = in.next();
            eid = in.nextInt();
            salary = in.nextFloat();
            E_Node n = new E_Node(name, gender, eid, salary);
            list.add(n);
        }
        //print series
        for(E_Node i:list)
        {
            i.print_Node();
        }

        //search for id
        System.out.println("Enter id to search:");
        int id=in.nextInt();
        boolean found=false;
        for(E_Node i:list)
        {
           if(i.eid==id)
           {
               System.out.println("Iyla found");
               i.print_Node();
               found=true;
               break;
           }
        }
        if(!found)
            System.out.println("Not Found");

        //update:---search---->found----delete--->new added
        //id will not change-->remaining details take again

    }
}
