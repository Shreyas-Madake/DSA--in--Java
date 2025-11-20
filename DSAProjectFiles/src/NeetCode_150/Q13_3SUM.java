package NeetCode_150;

import java.util.*;

public class Q13_3SUM {
    public List<List<Integer>> threeSum(int[] arr) {
        if(arr==null || arr.length<3){
            return new ArrayList<>();
        }
        //to store ans
        Arrays.sort(arr);
        Set<List<Integer>> result =new HashSet<>();
        //now fix the first element and find the other two
        for(int i=0;i<arr.length-2;i++){
            //find other two using two sum approach
            int left=i+1;
            int right=arr.length-1;
            while(left<right){
                int sum=arr[i]+arr[left]+arr[right];
                if(sum==0){
                    //add to set and move to other triplets
                    result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                    left++;
                    right--;
                }
                else if (sum<0)
                    left++;
                else
                    right--;
            }
        }
        return new ArrayList<>(result);
    }
}
