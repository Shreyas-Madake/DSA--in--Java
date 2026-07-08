package SDE_sheet;

public class Q12_findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                // Update maxCount if the current streak is the longest
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                // Streak broken, reset current count
                currentCount = 0;
            }
        }

        return maxCount;
    }
}
