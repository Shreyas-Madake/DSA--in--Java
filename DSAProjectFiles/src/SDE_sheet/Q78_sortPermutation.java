package SDE_sheet;

public class Q78_sortPermutation {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int res=0;
        boolean first=false;
        for(int i=0;i<n;i++){
            if(nums[i]==i) continue;
            else if(!first){
                res=nums[i];
                first=true;
            }
            else{
                res=res & nums[i];
            }
        }
        return res;
    }
}
