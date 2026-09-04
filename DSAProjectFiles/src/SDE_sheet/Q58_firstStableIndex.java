package SDE_sheet;

public class Q58_firstStableIndex {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int maxLeft = 0;

            // Find maximum from 0 to i
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, nums[j]);
            }

            int minRight = Integer.MAX_VALUE;;

            // Find minimum from i to n-1
            for (int j = i; j < n; j++) {
                minRight = Math.min(minRight, nums[j]);
            }

            int instability = maxLeft - minRight;

            if (instability <= k) {
                return i;
            }
        }

        return -1;
    }
}
