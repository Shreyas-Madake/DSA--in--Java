package SDE_sheet;

import java.util.Arrays;

public class Q55_eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {

        int n=intervals.length;
        Arrays.sort(intervals,(a, b)-> a[1]-b[1]);
        int removed=0;
        int lastend=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<lastend) removed++;
            else{
                lastend=intervals[i][1];
            }
        }
        return removed;

    }
}
