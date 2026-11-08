package DailyLeetcode;

import java.util.PriorityQueue;

public class Q08_assignTasks {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        // freeServers queue: sorted by weight, then index
        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // busyServers queue: sorted by finTime, then weight, then index
        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Long.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[] { servers[i], i });
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            // Move busy servers to free servers if they are free by i-th time
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= i) {
                long[] busy = busyServers.poll();
                long finTime = busy[0];
                int wt = (int) busy[1];
                int idx = (int) busy[2];
                freeServers.offer(new int[] { wt, idx });
            }

            if (freeServers.isEmpty()) {
                long[] busy = busyServers.poll();
                long finTime = busy[0];
                int wt = (int) busy[1];
                int idx = (int) busy[2];
                result[i] = idx;
                busyServers.offer(new long[] { finTime + tasks[i], wt, idx });
            } else {
                int[] free = freeServers.poll();
                int wt = free[0];
                int idx = free[1];
                result[i] = idx;
                busyServers.offer(new long[] { (long) i + tasks[i], wt, idx });
            }
        }

        return result;
    }
}
