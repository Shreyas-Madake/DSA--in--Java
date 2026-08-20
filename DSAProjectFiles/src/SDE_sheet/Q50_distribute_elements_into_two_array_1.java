package SDE_sheet;

import java.util.ArrayList;
import java.util.List;

public class Q50_distribute_elements_into_two_array_1 {
    public int[] resultArray(int[] nums) {
        int n=nums.length;

        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);

        for(int i=2;i<n;i++){
            if(l1.get(l1.size()-1) >l2.get(l2.size()-1)){
                l1.add(nums[i]);
            }else{
                l2.add(nums[i]);
            }


        }
        int[] result=new int[n];
        int index=0;
        for(int num:l1){
            result[index++]=num;

        }
        for(int num:l2){
            result[index++]=num;

        }
        return result;


    }
}
