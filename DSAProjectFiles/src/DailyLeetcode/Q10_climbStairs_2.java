package DailyLeetcode;

import java.util.Arrays;

public class Q10_climbStairs_2 {
    private int[] memo;

    private int solve(int i, int n, int[] costs) {
        if (i == n) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }

        int cost = Integer.MAX_VALUE;

        // we will calculate all costs in all direction i+1,i+1,i+3 way
        // then will take min of it
        int j = i + 1;
        if (j <= n) {
            cost = solve(j, n, costs) + costs[j - 1] + (j - i) * (j - i);// here we uses to caluculate cost and also move the recursion in that direction here  solve(j, n, costs) is as j=i+1 therefore we passes here j, as this is where we would jump
        }

        // jump of 2
        j = i + 2;
        if (j <= n) {
            cost = Math.min(cost, solve(j, n, costs) + costs[j - 1] + (j - i) * (j - i));
            // we calululating min of cost and also then recursion in that direction
        }

        // jump of 3
        j = i + 3;
        if (j <= n) {
            cost = Math.min(cost, solve(j, n, costs) + costs[j - 1] + (j - i) * (j - i));
        }

        return memo[i] = cost;
    }

    public int climbStairs(int n, int[] costs) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(0, n, costs);
    }
}
