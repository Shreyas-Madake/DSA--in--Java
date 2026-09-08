package SDE_sheet;

import java.util.Arrays;

public class Q61_Distinct_subsequence_2 {
    int MOD = 1000000007;

    public int distinctSubseqII(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];

        Arrays.fill(dp, -1);

        long totalSubsequences = solve(s, n, dp);

        // Subtract 1 to remove the empty subsequence, then modulo
        return (int) ((totalSubsequences - 1 + MOD) % MOD);
    }

    public long solve(String s, int i, long[] dp) {
        // Base case: 1 way to form an empty subsequence
        if (i == 0) {
            return 1;
        }

        // Memoization check
        if (dp[i] != -1) {
            return dp[i];
        }

        // Double the subsequences we had from the previous step
        long total = (2 * solve(s, i - 1, dp)) % MOD;

        // Check for duplicates: find the previous occurrence of s.charAt(i-1)
        long duplicate = 0;
        char c = s.charAt(i - 1);
        for (int k = i - 2; k >= 0; k--) {
            if (s.charAt(k) == c) {
                duplicate = solve(s, k, dp);
                break;
            }
        }

        // Subtract the duplicates and store in dp
        return dp[i] = (total - duplicate + MOD) % MOD;
    }
}
