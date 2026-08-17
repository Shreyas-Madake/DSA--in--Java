package SDE_sheet;

import java.util.PriorityQueue;

public class Q48_Find_Median_from_data_stream {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public Q48_Find_Median_from_data_stream() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>((a,b)->(b-a));
    }

    public void addNum(int num) {
        maxheap.offer(num);
        // <=
        if(!maxheap.isEmpty() && !minheap.isEmpty() && maxheap.peek() > minheap.peek()){
            int val = maxheap.poll();
            minheap.offer(val);
        }
        //size check
        if(maxheap.size() > minheap.size()+1){
            int val = maxheap.poll();
            minheap.offer(val);
        }

        if(minheap.size() > maxheap.size()+1){
            int val = minheap.poll();
            maxheap.offer(val);
        }
    }

    public double findMedian() {
        if(minheap.size()>maxheap.size()){
            return minheap.peek();
        }else if(maxheap.size()>minheap.size()){
            return maxheap.peek();
        }else {
            return (minheap.peek() + maxheap.peek())/2.0;
        }
    }
}
