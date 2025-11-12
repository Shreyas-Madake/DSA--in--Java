package NeetCode_150;

import java.util.HashSet;

public class Q10_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){//for NPE
            return 0;
        }
        HashSet<Integer> numset= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            numset.add(nums[i]);
        }
        int longestsub=1;//to store longest consecutive sequence
        for(int num:numset){
            if(numset.contains(num-1)){
                continue;//to check weather we are starting from any middle of
                // LCS if yes skip it
            }
            else{
                int currentnum=num;
                int currentsub = 1;//current maximum consecutive subsequence
                while(numset.contains(currentnum+1)){
                    currentnum++;
                    currentsub++;
                }
                longestsub=Math.max(longestsub,currentsub);
            }
        }
        return longestsub;
    }
}
