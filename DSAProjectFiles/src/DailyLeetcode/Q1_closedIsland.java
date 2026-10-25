package DailyLeetcode;

public class Q1_closedIsland {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j,n,m)) cnt++;

                }
            }
        }
        return cnt;

    }
    public boolean dfs(int[][] grid, int row, int col,int n, int m){
        if(row<0|| row>=n|| col<0||col>=m) return false;
        if(grid[row][col]==1) return true;
        grid[row][col] = 1;

        boolean top=dfs(grid,row-1,col,n,m);
        boolean right=dfs(grid,row,col+1,n,m);
        boolean left=dfs(grid,row,col-1,n,m);
        boolean bottom=dfs(grid,row+1,col,n,m);

        return top && right && left && bottom;

    }
}
