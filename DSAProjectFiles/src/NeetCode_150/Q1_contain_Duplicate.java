package NeetCode_150;

import java.util.HashSet;

public class Q1_contain_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        //create a Hashset to store elements from array
        HashSet<Integer> seenumbers=new HashSet<>();
        //iterate through each element in array
        for(int num:nums){
            //check if the element is already present in hashset or not
            if(seenumbers.contains(num)){
                return true;//Duplicate found
            }
            //add elemt into hashset
            seenumbers.add(num);
        }
        return false;//no duplicate
    }
}
