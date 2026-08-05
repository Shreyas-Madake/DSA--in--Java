package SDE_sheet;
class Q33_Compare_version_numbers {
    public int maxStrength(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = nums[i], b = nums[j];
                int g = GCD(a, b);

                int curr = (a / g) * (b / g);
                if (curr > ans) {
                    ans = curr;
                }
            }
        }

        return ans;
    }

    private int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}