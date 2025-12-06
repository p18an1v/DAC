package Queue_Examples;

import java.util.*;

public class Biding_Process
{
    public static void main(String[] args) {
        String bid;
        List<Integer> bid_list=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        while(true)//infinite while:Because the condition is true, it will never stop on its own.
        {
            System.out.println("Enter bid(blank to stop):");
            bid=in.nextLine().trim();
            //blank check
            if(bid.isEmpty())// =="" it fails
                break;
            else
            {
                bid_list.add(Integer.parseInt(bid));//store in bid_list
            }
        }
        System.out.println("Bids are:"+bid_list);
        System.out.println("Max is :"+Collections.max(bid_list));

    }
}
