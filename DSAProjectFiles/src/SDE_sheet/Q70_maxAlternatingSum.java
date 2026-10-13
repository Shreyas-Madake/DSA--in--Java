package SDE_sheet;

import java.util.Arrays;

public class Q70_maxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];


        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }


        Arrays.sort(squares);

        long score = 0;


        for (int i = 0; i < n / 2; i++) {
            score -= squares[i];
        }

        for (int i = n / 2; i < n; i++) {
            score += squares[i];
        }


        return score;
    }
}
