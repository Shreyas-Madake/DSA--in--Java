package NeetCode_150;

import java.util.ArrayList;
import java.util.List;

public class Q54_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        findcombinations( 0, candidates, target , ans,
                new ArrayList<>());
        return ans;
    }
    private void findcombinations(int ind, int [] arr,int target,List<List<Integer>> ans, List<Integer> ds){
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            findcombinations( ind, arr, target -arr[ind], ans,
                    ds);
            ds.remove(ds.size()-1);
        }
        findcombinations( ind+1, arr, target , ans,
                ds);
    }
}
