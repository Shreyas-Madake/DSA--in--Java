package NeetCode_150;

import java.util.PriorityQueue;

public class Q47_Kth_largest_elemenyin_stream {
    private PriorityQueue<Integer> minHeap;
    private int k;
    public void KthLargest(int k, int[] nums) {
        this.k=k;
        this.minHeap=new PriorityQueue<>(k);
        // to add initial elements to heap
        for(int num:nums){
            add(num);
        }
    }

    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.add(val);
        }else if(val>minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();

    }
}

