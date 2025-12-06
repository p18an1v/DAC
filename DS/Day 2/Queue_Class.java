package Queue_Examples;
import java.util.Scanner;
public class Queue_Class
{
    int queue[];
    int front,rear,MaxSize;
    void create_Queue(int size)
    {
        rear=-1;
        front=0;
        MaxSize=size;
        queue=new int[MaxSize];
    }
    //enqueue:accepts an element in queue
//rear+1
    void enqueue(int e)
    {
        queue[++rear]=e;
    }
    boolean is_full()
    {
        return(rear==MaxSize-1);
    }


    int dequeue()
    {
        int temp=queue[front];
        front++;
        return(temp);
        //return(queue[front++);
    }

    boolean is_empty()
    {
        if(front>rear)
            return true;
        else
            return false;
        //return(front>rear);
    }

    void print_queue()//in FIFO-->front to rear
    {
        for(int i=front;i<=rear;i++)
            System.out.print(queue[i]+" - ");
    }



}
