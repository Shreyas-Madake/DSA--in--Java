package SDE_sheet;

public class Q06_Majority_element_1 {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int el = 0; // Initialize el to avoid compilation errors

        // First pass: Find a candidate for the majority element
        for (int i = 0; i < nums.length; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (nums[i] == el) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // Second pass: Verify the candidate
        int cnt1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }

        if (cnt1 > (nums.length / 2)) {
            return el;
        }

        return -1;
    }
}
