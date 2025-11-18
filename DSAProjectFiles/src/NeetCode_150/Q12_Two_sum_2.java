package NeetCode_150;

public class Q12_Two_sum_2 {
    public int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]<target){
                i++;
            }else if(nums[i]+nums[j]>target){
                j--;
            }else{
                return new int[]{i+1,j+1};
            }
        }
        return null;//as we have to return something else it will not compile


    }
}
