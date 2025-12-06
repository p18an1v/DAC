package Queue_Examples;

public class Two_Queue_in_an_Array
{
    int queue[];
    int front1,rear1,front2,rear2,MaxSize;
    void create_Queue(int size)
    {
        rear1=-1;
        front1=0;
        rear2=MaxSize;
        front2=MaxSize-1;
        MaxSize=size;
        queue=new int[MaxSize];
    }
    //enqueue:accepts an element in queue
//rear+1
    void enqueue1(int e)
    {
        queue[++rear1]=e;
    }
    void enqueue2(int e)
    {
        queue[--rear2]=e;
    }
    boolean is_full()
    {
        return((rear2-1)==rear1);
        //((rear2==(rear1+1));
    }



    int dequeue1()
    {
        int temp=queue[front1];
        front1++;
        return(temp);
        //return(queue[front++);
    }
    int dequeue2()
    {
        int temp=queue[front2];
        front2--;
        return(temp);
        //return(queue[front++);
    }

    boolean is_empty1()
    {
        if(front1>rear1)
            return true;
        else
            return false;
        //return(front>rear);
    }
    boolean is_empty2()
    {
        if(front2<rear2)
            return true;
        else
            return false;
        //return(front>rear);
    }

    void print_queue1()//in FIFO-->front to rear
    {
        for(int i=front1;i<=rear1;i++)
            System.out.print(queue[i]+" - ");
    }
    void print_queue2()//in FIFO-->front to rear
    {
        for(int i=front2;i>=rear2;i--)
            System.out.print(queue[i]+" - ");
    }


}
