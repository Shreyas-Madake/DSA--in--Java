package NeetCode_150;

import java.util.PriorityQueue;

public class Q48_Last_Stone_Weight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a, b)->b-a);
        for(int stone:stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size()>1){
            int y=maxHeap.poll();
            int x=maxHeap.poll();
            if(x!=y){
                maxHeap.add(y-x);
            }
            // if y == x → both destroyed, do nothing
        }
        // If heap is empty → all stones destroyed
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();


    }
}
