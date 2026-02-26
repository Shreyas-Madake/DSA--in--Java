package NeetCode_150;

import java.util.PriorityQueue;

public class Q49_Kth_largest_element_inarray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        for(int num:nums){
            minheap.add(num);
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        return minheap.peek();

    }
}
