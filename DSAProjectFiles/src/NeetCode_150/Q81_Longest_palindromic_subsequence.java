package NeetCode_150;

import java.util.Arrays;

public class Q81_Longest_palindromic_subsequence {
    public int longestPalindromeSubseq(String s) {
        StringBuilder str=new StringBuilder(s);
        return longestCommonSubsequence(s,str.reverse().toString());

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int [n+1][m+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recur(n,m,text1,text2,dp);// insted of n-1 and m-1 shifting logic

    }
    public int recur(int i, int j, String text1, String text2,int dp[][]){
        //base case
        if(i==0||j==0){// instead of i<0||j<0
            dp[i][j]=0;
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(text1.charAt(i-1)==text2.charAt(j-1)){// instead of text1.charAt(i)==text2.charAt(j)
            dp[i][j]=1+recur(i-1,j-1,text1,text2,dp);
            return dp[i][j];
        }
        else{
            int case1=recur(i-1,j,text1,text2,dp);
            int case2=recur(i,j-1,text1,text2,dp);
            dp[i][j]=Math.max(case1,case2);
            return dp[i][j];
        }
    }
}
