package NeetCode_150;

import java.util.Arrays;

public class Q73_cheapest_flights_within_k_stops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int price[]=new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        price[src]=0;
        for(int i=0;i<k+1;i++){
            int temp[]=Arrays.copyOf(price,n);//copy only values
            for(int flight[]:flights){
                int u=flight[0];
                int v=flight[1];
                int w=flight[2];
                if(price[u]!=Integer.MAX_VALUE && price[u]+w<temp[v]){
                    temp[v]=price[u]+w;
                }
            }
            price=temp;//copy temp to price
        }
        return(price[dst]==Integer.MAX_VALUE)?-1:price[dst];
    }
}
