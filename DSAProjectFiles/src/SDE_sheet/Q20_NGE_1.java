package SDE_sheet;
import java.util.HashMap;
import java.util.Stack;

public class Q20_NGE_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nge = new int[nums1.length];
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse nums2 from right to left to build the Next Greater Element map
        for (int i = nums2.length - 1; i >= 0; i--) {
            // Pop elements from stack that are smaller than or equal to the current element
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }

            // If stack is empty, there is no greater element on the right (-1)
            // Otherwise, the top of the stack is the next greater element
            if (st.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], st.peek());
            }

            // Push current element into the stack for subsequent elements
            st.push(nums2[i]);
        }

        // Map the answers back to nums1
        for (int i = 0; i < nums1.length; i++) {
            nge[i] = map.get(nums1[i]);
        }

        return nge;
    }
}
