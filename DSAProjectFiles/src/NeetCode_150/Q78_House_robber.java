package NeetCode_150;
import  java.util.*;

public class Q78_House_robber {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];//as shifting to avoid -1 index in dp array
        Arrays.fill(dp,-1);
        return recur(nums,n,dp);//intead of n-1 to avoid -1 index in dp array
    }
    public int recur(int nums[],int index,int dp[]){
        //base case
        if(index==1){
            dp[index]=nums[0];
            return nums[0];
        }
        if(index==0){// see no -1 as we shifted to avoid it
            dp[index]=0;
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        //pick non pick logic
        int pick=nums[index-1] +recur(nums,index-2,dp);
        int nopick= 0 +recur(nums,index-1,dp);
        dp[index]=Math.max(pick,nopick);
        return dp[index];
    }
}
