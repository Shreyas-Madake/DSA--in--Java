package NeetCode_150;
import java.util.*;
public class Q71_Min_cost_to_connect_allpoints {
    public int minCostConnectPoints(int[][] points) {
        // prism Algo
        PriorityQueue<int []> pq=new PriorityQueue<int[]>((a,b)->(a[2]-b[2]));// we nned to compare cost its on index 2
        int cost=0;
        //)StartID,EndId,Distance between start to end) same like we did(p,n,w) startId= startnode
        pq.offer(new int[]{0,0,0});
        Set<Integer>visited=new HashSet<Integer>();
        int num=points.length;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();//P as we starting from 0 and not -1
            int endId=curr[1];//N
            int currcost=curr[2];//W
            if(visited.contains(curr[1])) continue;
            cost+=currcost;
            visited.add(curr[1]);

            for(int i=0;i<num;i++){//this loop is exploring all unvisited neighbors of the current node.
                //in a normal graph, neighbors are only the nodes directly connected by edges. but here every point is connected to every other point — so all unvisited points are neighbors.
                if(!visited.contains(i)){
                    pq.offer(new int[]{endId,i,distance(points,endId,i)});//endid=from that node to i
                }
            }

        }
        return cost;

    }
    private int distance(int[][] points,int i,int j){
        return Math.abs(points[i][0]-points[j][0]) +Math.abs(points[i][1]-points[j][1]);
    }
}
