package SDE_sheet;
import java.util.LinkedList;
import java.util.Queue;
public class Q18_Implement_stack_using_queues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Q18_Implement_stack_using_queues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }


    public void push(int x) {

        q2.add(x);


        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }


        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.remove();
    }


    public int top() {
        return q1.peek();
    }


    public boolean empty() {
        return q1.isEmpty();
    }
}
