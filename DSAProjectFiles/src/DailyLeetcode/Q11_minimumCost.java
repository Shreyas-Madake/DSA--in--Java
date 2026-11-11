package DailyLeetcode;

public class Q11_minimumCost {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        //vvvi imp question
        // If costBoth is more expensive than buying them individually, just buy them separately
        if(cost1+cost2<=costBoth){
            return ((long) need1 * cost1) + ((long) need2 * cost2);
        }
        int both = Math.min(need1, need2);
        long total = (long) both * costBoth;

        need1 -= both;
        need2 -= both;

        if (need1 > 0) {
            total += (long) need1 * Math.min(cost1, costBoth);
        } else if (need2 > 0) {
            total += (long) need2 * Math.min(cost2, costBoth);
        }

        return total;
    }
}
