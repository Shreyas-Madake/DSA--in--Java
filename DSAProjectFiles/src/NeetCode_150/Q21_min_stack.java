package NeetCode_150;

import java.util.Stack;

public class Q21_min_stack {
    public class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minstack;


        public MinStack() {
            stack = new Stack<Integer>();
            minstack = new Stack<Integer>();
        }

        public void push(int val) {
            stack.push(val);
            if (minstack.isEmpty() || val <= minstack.peek()) {
                minstack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }

            int val = stack.pop();
            if (val == minstack.peek()) {
                minstack.pop();
            }
        }
    }
}
