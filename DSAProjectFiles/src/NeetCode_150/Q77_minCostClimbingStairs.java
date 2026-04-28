package NeetCode_150;

public class Q77_minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        for(int state=2;state<=n;state++){
            int onestep=cost[state-1]+dp[state-1];
            int twostep=cost[state-2]+dp[state-2];
            dp[state]=Math.min(onestep,twostep);
        }
        return dp[n];

    }
}
