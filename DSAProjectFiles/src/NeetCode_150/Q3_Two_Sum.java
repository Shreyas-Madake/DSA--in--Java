package NeetCode_150;

import java.util.HashMap;
import java.util.Map;

public class Q3_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        //Create a HashMap to store number and its Index value
        Map<Integer,Integer> map=new HashMap<>();
        //ieterate through the array
        for(int i=0;i<nums.length;i++){
            //calculate the complement of the current value
            int complement= target-nums[i];
            //check if the complement is already in the map
            if(map.containsKey(complement)){
                //if found return the indices of the complement and the current number
                return new int[]{map.get(complement),i};
            }
            //else add the current number and its indices to map
            map.put(nums[i],i);
        }
        return new int[] {};
    }


}
