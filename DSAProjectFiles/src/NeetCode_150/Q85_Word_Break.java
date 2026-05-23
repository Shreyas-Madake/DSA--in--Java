package NeetCode_150;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q85_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        //convert the dictionary to set for O(1) lookups
        Set<String> wordset=new HashSet<>(wordDict);
        // find the maximum word in dictionary
        int maxlength=0;
        for(String word:wordDict){
            maxlength=Math.max(maxlength,word.length());
        }
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        // base case
        dp[0]=true;
        for(int i=1;i<=n;i++){// this loop to itterate over each letter in string s
            // check prefix of length upto maxlength
            for(int j=i-1;j>=Math.max(0,i-maxlength);j--){
                if(dp[j]&& wordset.contains(s.substring(j,i))){// dp[j] means till j position the segment should be true
                    dp[i]=true;
                    break;//no need to chech further prefix
                }
            }

        }
        return dp[n];

    }
}
