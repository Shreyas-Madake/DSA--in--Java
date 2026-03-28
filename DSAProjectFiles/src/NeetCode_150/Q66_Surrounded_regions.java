package NeetCode_150;

public class Q66_Surrounded_regions {
    public void solve(char[][] board) {
        int m=board.length;
        int n= board[0].length;
        // step:1 border and connected zeros mark them as 'V'
        for(int j=0;j<n;j++){
            if(board[0][j]=='O') dfs(0,j,m,n,board);
            if(board[m-1][j]=='O') dfs(m-1,j,m,n,board);
        }
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(i,0,m,n,board);
            if(board[i][n-1]=='O') dfs(i,n-1,m,n,board);
        }

        // step 2:convert 'O' to 'X' which can be flip as not attached to borders
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]='X';
            }
        }
        // step:3 convert all 'v' againg back to'O'( that cannot be fliped)
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='V') board[i][j]='O';
            }
        }
    }

    private boolean isSafe(int i, int j, int m, int n){
        return (i>=0 && i<m && j>=0 && j<n);
    }

    private void dfs(int r, int c, int m, int n, char[][] board){
        board[r][c]='V';
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        for(int k=0;k<4;k++){
            int newr=r+dir[k][0];
            int newc= c+dir[k][1];
            if(isSafe(newr,newc,m,n)&& board[newr][newc]=='O'){
                dfs( newr,  newc,  m,  n,  board);
            }
        }

    }
}
