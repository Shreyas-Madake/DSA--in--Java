package SDE_sheet;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Q72_minSwaps {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            arr[i][0] = nums[i];
            arr[i][1] = sum;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        Map<Integer, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            index.put(nums[i], i);
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int correctIndex = index.get(arr[i][0]);

            if (correctIndex != i) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;

                index.put(nums[correctIndex], correctIndex);
                index.put(nums[i], i);

                swaps++;
            }
        }

        return swaps;
    }
}
