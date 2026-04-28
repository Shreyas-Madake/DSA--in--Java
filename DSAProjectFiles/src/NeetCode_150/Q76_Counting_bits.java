package NeetCode_150;

public class Q76_Counting_bits {
    public int[] countBits(int n) {
        int dp[]=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=dp[i>>1]+(i&1);
        }
        return dp;
    }
}
