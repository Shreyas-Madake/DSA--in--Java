package SDE_sheet;
import java.util.Stack;
public class Q66_scoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int top = stack.pop();
                int A = Math.max(2 * top, 1);
                int B = stack.pop();
                stack.push(A + B);
            }
        }

        return stack.pop();
    }
}
