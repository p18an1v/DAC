package Queue_Examples;



import java.util.Scanner;

public class Queue_Main
{
    public static void main(String[] args)
    {
        //Queue_Class obj=new Queue_Class();
        //Circular_Queue obj=new Circular_Queue();
        Priority_Queue obj=new Priority_Queue();
        int choice;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter size of queue:");
        int size=in.nextInt();
        obj.create_Queue(size);
        do
        {
            System.out.println("\nQueue Menu");
            System.out.println("==========");
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.Print");
            System.out.println("0.Exit");
            System.out.println("--------");
            System.out.print(":");
            choice=in.nextInt();
            switch(choice)
            {
                case 1:
                    if(!obj.is_full())//if not full then
                    {
                        System.out.println("Enter element to enter:");
                        int e=in.nextInt();
                        obj.enqueue(e);
                        System.out.println("Element Enqueued");
                    }
                    else
                    {
                        System.out.println("Queue Full");
                    }
                    break;
                case 2:
                    if(!obj.is_empty())//if not empty then
                    {
                        System.out.println("Element Dequeued:"+obj.dequeue());
                    }
                    else
                    {
                        System.out.println("Queue Empty");
                    }
                    break;
                case 3:
                    if(!obj.is_empty())//if not empty then
                    {
                        System.out.println("Queue has:");
                        obj.print_queue();
                    }
                    else
                    {
                        System.out.println("Queue Empty");
                    }
                    break;
                case 0:
                    System.out.println("Thanks for using the code: amar.career");
                    break;
                default:
                    System.out.println("check the option selected.");
                    break;

            }
        }while(choice!=0);
    }
}
