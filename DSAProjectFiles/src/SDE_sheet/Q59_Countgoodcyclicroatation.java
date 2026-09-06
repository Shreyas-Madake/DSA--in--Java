package SDE_sheet;

public class Q59_Countgoodcyclicroatation {
    public int countGoodCyclicRotations(int[] nums) {
        int n = nums.length;
        int hafl = n / 2;
        int c = 0;


        long[] prefixsum = new long[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            prefixsum[i + 1] = prefixsum[i] + nums[i % n];
        }


        for (int i = 0; i < n; i++) {

            long sum1 = prefixsum[i + hafl] - prefixsum[i];


            long sum2 = prefixsum[i + n] - prefixsum[i + hafl];


            if (sum1 > sum2) {
                c++;
            }
        }

        return c;
    }
}
