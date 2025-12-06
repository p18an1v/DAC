package Queue_Examples;

public class Circular_Queue
{
    int queue[];
    int front,rear,MaxSize,count;
    void create_Queue(int size)
    {
        rear=-1;
        front=0;
        MaxSize=size;
        count=0;
        queue=new int[MaxSize];
    }
    //enqueue:accepts an element in queue
//rear+1
    void enqueue(int e)
    {
        rear=(rear+1)%MaxSize;
        count++;
        queue[rear]=e;
    }
    boolean is_full()
    {
        return(count==MaxSize);
    }


    int dequeue()
    {
        int temp=queue[front];
        front=(front+1)%MaxSize;
        count--;
        return(temp);
        //return(queue[front++);
    }

    boolean is_empty()
    {
        return(count==0);
    }

    void print_queue()//in FIFO-->front to rear
    {
      int i=front,c=0;
      while(c<count)
      {
          System.out.print(queue[i]+" - ");
          i=(i+1)%MaxSize;
          c++;
      }

    }


}
