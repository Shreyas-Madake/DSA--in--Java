package NeetCode_150;

public class Q16_Best_Time_To_Buy_And_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
    }
}
