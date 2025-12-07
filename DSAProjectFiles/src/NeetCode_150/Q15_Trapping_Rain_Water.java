package NeetCode_150;

public class Q15_Trapping_Rain_Water {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int total=0;
        int leftmax=height[0];
        int rightmax=height[right];

        while(left<right){
            if(height[left]<height[right]){
                leftmax=Math.max(leftmax,height[left]);
                if(leftmax-height[left]>0){
                    total=total+ leftmax-height[left];
                }
                left++;
            }
            else{
                rightmax=Math.max(rightmax,height[right]);
                if(rightmax-height[right]>0){
                    total=total+ rightmax-height[right];
                }
                right--;
            }
        }
        return total;
    }
}
