package NeetCode_150;

import java.util.ArrayList;
import java.util.List;

public class Q55_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums);
        return result;

    }
    private void backtrack(List<List<Integer>> result, ArrayList<Integer> templist,int []nums){
        if(templist.size()==nums.length){
            result.add(new ArrayList<>(templist));
            return;
        }
        for(int number:nums){
            if(templist.contains(number)){
                continue;
            }
            templist.add(number);
            backtrack(result,templist,nums);
            templist.remove(templist.size()-1);
        }
    }
}
