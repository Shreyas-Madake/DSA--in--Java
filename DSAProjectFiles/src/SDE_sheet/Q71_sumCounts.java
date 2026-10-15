package SDE_sheet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q71_sumCounts {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        for(int i=0;i<nums.size();i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<nums.size();j++){
                set.add(nums.get(j));
                ans+= set.size()*set.size();
            }
        }
        return ans;

    }
}
