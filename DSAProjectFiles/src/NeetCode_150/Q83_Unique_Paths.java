package NeetCode_150;

import java.util.Arrays;

public class Q83_Unique_Paths {
    public int uniquePaths(int m, int n) {
        // we are done shifting logic to avoid -ve index
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(m,n,dp);
    }
    public int recur(int m,int n, int dp[][]){
        //base case
        if(m==1 && n==1){
            dp[m][n]=1;
            return 1;
        }
        if(m==0|| n==0){
            dp[m][n]=0;
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        int ways=recur(m-1,n,dp)+recur(m,n-1,dp);
        dp[m][n]=ways;
        return dp[m][n];
    }
}
