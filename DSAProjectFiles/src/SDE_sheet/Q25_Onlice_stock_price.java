package SDE_sheet;
import java.util.Stack;

public class Q25_Onlice_stock_price {
    private Stack<int[]> st;
    private int ind;

    public Q25_Onlice_stock_price() {
        st = new Stack<>();
        ind = -1;
    }

    public int next(int price) {
        ind = ind + 1;


        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }


        int ans = ind - (st.isEmpty() ? -1 : st.peek()[1]);


        st.push(new int[]{price, ind});

        return ans;
    }
}
