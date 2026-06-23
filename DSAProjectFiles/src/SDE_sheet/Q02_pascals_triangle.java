package SDE_sheet;
import java.util.ArrayList;
import java.util.List;

public class Q02_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // Each row starts with 1
            row.add(1);

            // Fill the middle elements based on the previous row
            if (i > 0) {
                List<Integer> prevRow = ans.get(i - 1);
                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                // Each row ends with 1
                row.add(1);
            }

            ans.add(row);
        }
        return ans;
    }
}
