package SDE_sheet;

public class Q62_jump_game {
    public boolean canJump(int[] nums) {
        int maxindex=0;
        int i=0;
        int n=nums.length;

        while(i<=maxindex){
            maxindex=Math.max(maxindex,i+nums[i]);
            if(maxindex>=(n-1)){
                return true;
            }
            i++;
        }
        return false;
    }
}
