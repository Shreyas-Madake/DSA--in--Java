package SDE_sheet;

public class Q75_gamestone {
    public boolean stoneGame(int[] piles) {
        Integer[][] dp=new Integer[piles.length][piles.length];
        int max=currplayeradv(piles,0,piles.length-1,dp);
        if(max>0) return true;
        else return false;

    }
    public int currplayeradv(int[] nums, int left, int right,Integer[][] dp){
        if(left==right) return nums[left];
        if(dp[left][right]!=null) return dp[left][right];
        int leftside=nums[left]- currplayeradv(nums,left+1,right,dp);
        int rightside=nums[right]-currplayeradv(nums,left,right-1,dp);

        return dp[left][right]=Math.max(leftside,rightside);
    }
}
