package SDE_sheet;

public class Q03_Next_permutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1; // Pivot index

        // 1. Find the first decreasing element from the end
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }

        // 2. If no such element exists, the permutation is the last one; reverse the whole array
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 3. Find the element just larger than nums[ind] to swap with
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }

        // 4. Reverse the subarray after the pivot index to get the smallest lexicographical order
        reverse(nums, ind + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
