package NeetCode_150;

public class Q74_fibonacci_number {
    public int fib(int n) {
        int dp[]=new int[n+1];
        if(n<=1){
            return n;
        }
        // base case
        dp[0]=0;
        dp[1]=1;
        for(int state=2;state<=n;state++){
            dp[state]=dp[state-1]+dp[state-2];
        }
        return dp[n];// return at what state ur are(which was asked)

    }
}
