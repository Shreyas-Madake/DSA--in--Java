package DailyLeetcode;

public class Q12_longestMonotonicSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int res = 1;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[j - 1]) {
                    res = Math.max(res, j - i + 1);
                } else {
                    break;
                }
            }

            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[j - 1]) {
                    res = Math.max(res, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
