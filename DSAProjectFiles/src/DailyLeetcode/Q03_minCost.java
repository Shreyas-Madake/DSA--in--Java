package DailyLeetcode;

import java.util.Arrays;

public class Q03_minCost {
    public int minCost(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][1024];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(grid,0,0,0,dp);

    }
    public int solve(int[][] grid,int row,int col,int xor,int[][][] dp){
        int n=grid.length;
        int m=grid[0].length;

        // base cases
        // invalid path
        if(row<0 || row>=n || col<0|| col>=m) return Integer.MAX_VALUE;
        // currect cell xor
        xor^=grid[row][col];
        //when reached at last cell
        if(row==n-1 && col==m-1) return xor;

        if(dp[row][col][xor]!=-1){
            return dp[row][col][xor];
        }

        //Exploring all paths
        int right=solve(grid,row,col+1,xor,dp);
        int down=solve(grid,row+1,col,xor,dp);

        return dp[row][col][xor]= Math.min(right,down);

    }
}
