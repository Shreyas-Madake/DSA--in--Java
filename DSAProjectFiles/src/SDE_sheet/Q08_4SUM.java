package SDE_sheet;
import java.util.*;
public class Q08_4SUM {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        // Use a Set to store unique quadruplets
        Set<List<Integer>> st = new HashSet<>();

        // Loop for the first element
        for (int i = 0; i < n; i++) {
            // Loop for the second element
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                // Loop for the third element
                for (int k = j + 1; k < n; k++) {
                    long sum = (long)nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;

                    // If the required fourth element exists in the set
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                    // Add the third element to the hashset for future checks
                    hashset.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(st);
    }
}
