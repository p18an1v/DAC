package Queue_Examples;

public class Max_Profit
{
    static void Profit_Maker(int n[])
    {
        int Max_Profit=0,Buy_on=0,Sell_on=0;
        for(int buy=0;buy<n.length-1;buy++)
        {
            for(int sell=n.length-1;sell>buy;sell--)
            {
                int profit=n[sell]-n[buy];
                if(profit>Max_Profit)
                {
                    Max_Profit=profit;
                    Buy_on=buy;
                    Sell_on=sell;
                }
            }
        }
        System.out.println("Max Profit "+Max_Profit+" by buy on "+Buy_on+" and sell on"+Sell_on);
    }

    public static void main(String[] args)
    {
        int a[]={100,180, 260, 310 ,40 ,535, 695, 30, 50, 70 ,20 ,40 ,60 ,90, 10
        };
        Max_Profit.Profit_Maker(a);

    }
}
