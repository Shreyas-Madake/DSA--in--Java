package DailyLeetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q07_countServers {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;

        // Sort logs on the basis of time (index 1) in ascending order
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        int[] result = new int[q];

        // Store {time, originalIdx} for each query
        int[][] timeIndex = new int[q][2];
        for (int i = 0; i < q; i++) {
            timeIndex[i][0] = queries[i];
            timeIndex[i][1] = i;
        }

        // Sort timeIndex based on the query time
        Arrays.sort(timeIndex, (a, b) -> Integer.compare(a[0], b[0]));

        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0;
        int j = 0;

        for (int[] pair : timeIndex) {
            int time = pair[0];
            int idx = pair[1];

            // Range
            int start = time - x;
            int end = time;

            // Expansion: Add logs that fall within the current query window [start, end]
            while (j < m && logs[j][1] <= end) {
                mp.put(logs[j][0], mp.getOrDefault(logs[j][0], 0) + 1);
                j++;
            }

            // Shrinking: Remove logs that fall outside the left bound of the window (< start)
            while (i < m && logs[i][1] < start) {
                mp.put(logs[i][0], mp.get(logs[i][0]) - 1);
                if (mp.get(logs[i][0]) == 0) {
                    mp.remove(logs[i][0]);
                }
                i++;
            }

            // mp.size() = number of servers getting requests in the [start, end] window
            result[idx] = n - mp.size();
        }

        return result;
    }
}
