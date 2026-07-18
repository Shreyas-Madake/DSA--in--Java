package SDE_sheet;
import java.util.Stack;
public class Q19_Implement_queue_using_stack {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public Q19_Implement_queue_using_stack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // O(1) time complexity
    public void push(int x) {
        input.push(x);
    }

    // Amortized O(1) time complexity
    public int pop() {
        peek(); // Reuses peek() logic to ensure output stack is populated
        return output.pop();
    }

    // Amortized O(1) time complexity
    public int peek() {
        // If the output stack is empty, pour everything from input to output
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    // O(1) time complexity
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
