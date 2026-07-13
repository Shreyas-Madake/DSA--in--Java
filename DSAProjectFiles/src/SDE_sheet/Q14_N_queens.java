package SDE_sheet;
import java.util.ArrayList;
import java.util.List;
public class Q14_N_queens {
    public boolean isSafe1(int row, int col, char[][] board, int n) {
        // check upper diagonal
        int duprow = row;
        int dupcol = col;

        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        col = dupcol;
        row = duprow;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    public void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe1(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the empty board with dots
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(0, board, ans, n);
        return ans;
    }

    // Helper method to convert the internal char array board configuration to a List of Strings
    private List<String> construct(char[][] board) {
        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            internal.add(new String(board[i]));
        }
        return internal;
    }
}
