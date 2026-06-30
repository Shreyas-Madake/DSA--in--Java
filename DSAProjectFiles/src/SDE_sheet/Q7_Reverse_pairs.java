package SDE_sheet;

public class Q7_Reverse_pairs {
    private int cnt = 0;

    public int reversePairs(int[] nums) {
        cnt = 0;
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(nums, low, mid); // Sort left half
        mergeSort(nums, mid + 1, high); // Sort right half
        countPairs(nums, low, mid, high); // Count reverse pairs
        merge(nums, low, mid, high); // Merge sorted halves
    }

    private void countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            // Check condition: nums[i] > 2 * nums[right]
            while (right <= high && (long)nums[i] > 2L * nums[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) temp.add(nums[left++]);
        while (right <= high) temp.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}
