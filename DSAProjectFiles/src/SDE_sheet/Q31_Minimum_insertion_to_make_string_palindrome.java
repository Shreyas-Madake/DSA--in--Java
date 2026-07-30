package SDE_sheet;
import java.util.Arrays;
public class Q31_Minimum_insertion_to_make_string_palindrome {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        return longestCommonSubsequence(s, str.reverse().toString());
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return recur(n, m, text1, text2, dp);
    }

    public int recur(int i, int j, String text1, String text2, int dp[][]) {
        // Base case: 1-based indexing means 0 represents empty string
        if (i == 0 || j == 0) {
            dp[i][j] = 0;
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Compare using (i-1) and (j-1) due to index shifting
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            return dp[i][j] = 1 + recur(i - 1, j - 1, text1, text2, dp);
        } else {
            int case1 = recur(i - 1, j, text1, text2, dp);
            int case2 = recur(i, j - 1, text1, text2, dp);
            return dp[i][j] = Math.max(case1, case2);
        }
    }

    public int minInsertions(String s) {
        // Fixed: Call longestPalindromeSubseq instead of longestCommonSubsequence
        return s.length() - longestPalindromeSubseq(s);
    }
}
