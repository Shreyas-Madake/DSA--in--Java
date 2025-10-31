package NeetCode_150;

public class Q7_Product_Of_Array_Except_Itself {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] res=new int[n];
        int productOfAllBeforeCurrent=1;
        int productOfAllAfterCurrent=1;
        for(int i=0;i<n;i++){
            res[i]=productOfAllBeforeCurrent;
            productOfAllBeforeCurrent *= nums[i];
        }
        for(int i=n-1;i>=0;i--){
            res[i]*=productOfAllAfterCurrent;
            productOfAllAfterCurrent*=nums[i];
        }
        return res;

    }
}
