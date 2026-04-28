package NeetCode_150;

public class Q75_Climbing_stairs {
    public int climbStairs(int n) {
        //Base Case
        if(n<=2){
            return n;
        }
        int dp[]=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int state=3;state<=n;state++){
            dp[state]=dp[state-1]+dp[state-2];
        }
        return dp[n];
    }
}
