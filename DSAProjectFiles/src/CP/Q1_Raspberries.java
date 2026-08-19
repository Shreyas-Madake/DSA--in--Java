package CP;

import java.util.Scanner;

public class Q1_Raspberries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLong()) return;
        long t = sc.nextLong();
        while (t-- > 0) {
            int n = sc.nextInt();
            long k = sc.nextLong();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            long ans=Integer.MAX_VALUE;
            int even=0;
            for(int i=0;i<n;i++){
                if(arr[i]%2==0){
                    even++;
                }
                if(arr[i]%k==0){
                    ans=0;
                }
                ans=Math.min(ans,(k-arr[i]%k));
            }
            if (k == 4) {
                if (even >= 2) {
                    ans = Math.min(ans, 0L);
                } else if (even == 1) {
                    ans = Math.min(ans, 1L);
                } else if (even == 0) {
                    ans = Math.min(ans, 2L);
                }
            }
            System.out.println(ans);
        }

    }
}