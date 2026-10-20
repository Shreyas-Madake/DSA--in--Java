package SDE_sheet;

import java.util.Arrays;

public class Q76_minpathsum {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return fun(grid,0,0,n,m,dp);


    }
    public int fun(int[][] grid, int row,int col,int n, int m,int[][] dp){
        // so that this path is never chosen as the minimum.
        if(row>=n || col>=m)  return Integer.MAX_VALUE;
        if(row==n-1 && col==m-1) return grid[row][col];
        if(dp[row][col]!=-1) return dp[row][col];
        int down=fun(grid,row+1,col,n,m,dp);
        int right=fun(grid,row,col+1,n,m,dp);


        return dp[row][col]= grid[row][col]+Math.min(down,right);
    }
}
