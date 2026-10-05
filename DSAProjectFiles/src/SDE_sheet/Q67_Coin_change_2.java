package SDE_sheet;

import java.util.Arrays;

public class Q67_Coin_change_2 {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[amount+1][coins.length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return help(amount,coins,0,dp);

    }
    public int help(int amount, int[] coins,int index,int[][] dp){
        if(amount==0){
            return 1;
        }
        if(amount<0 || index==coins.length){
            return 0;
        }
        if(dp[amount][index]!=-1){
            return dp[amount][index];
        }
        int ans=0;
        for(int i=index;i<coins.length;i++){
            if(amount>=coins[i]){
                ans+=help(amount-coins[i],coins,i,dp);
            }
        }
        return dp[amount][index]=ans;
    }
}
