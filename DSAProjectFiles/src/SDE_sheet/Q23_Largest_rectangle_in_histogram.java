package SDE_sheet;
import java.util.Stack;
public class Q23_Largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        int []ns=nextsmaller(heights);
        int []ps=prevsmaller(heights);
        int max= Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int height=heights[i];
            int width=ns[i]-ps[i]-1;
            int ans=height*width;
            max=Math.max(max,ans);

        }
        return max;


    }
    private int[] nextsmaller(int arr[]){
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=n;
            }
            else{
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    private int[] prevsmaller(int arr[]){
        int n=arr.length;
        Stack<Integer> stack=new Stack<>();
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}
