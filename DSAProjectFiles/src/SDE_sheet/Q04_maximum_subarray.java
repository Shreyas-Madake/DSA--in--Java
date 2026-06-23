package SDE_sheet;

public class Q04_maximum_subarray {
    public int maxSubArray(int[] nums) {

        int maxSoFar = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;


            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }


            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSoFar;
    }
}
