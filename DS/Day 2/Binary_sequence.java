package Queue_Examples;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Queue;

public class Binary_sequence
{
    static void binary_sequence_printer(int n)
    {
        //use ArrayDeque of String
        Queue<String> bin=new ArrayDeque<>();
        //add 1 to front
        bin.add("1");
        //run this
        for(int i=1;i<n;i++)
        {
            //print front and remove it
            String current=bin.poll();
            System.out.print("\n"+i+"-----"+current);
            //add element at front+"0" to ArrayDeque
            bin.add(current+"0");
            //add element at front+"1" to ArrayDeque
            bin.add(current+"1");
        }

    }
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter n:");
        int n=in.nextInt();
        Binary_sequence.binary_sequence_printer(n);

    }
}
