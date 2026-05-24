package NeetCode_150;

public class Q86_partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        Boolean dp[][]=new Boolean[nums.length][(sum/2)+1];
        return canPartitionrec(nums,0,sum/2,dp);
    }
    public boolean canPartitionrec(int nums[],int i, int target,Boolean dp[][]){
        if(target==0){
            return true;
        }
        if(i>=nums.length|| target<0){
            return false;
        }
        if(dp[i][target]!=null){// as boolean therfore not -1
            return dp[i][target];
        }
        dp[i][target]= canPartitionrec(nums,i+1,target-nums[i],dp)||canPartitionrec(nums,i+1,target,dp);
        return dp[i][target];
    }
}
