package NeetCode_150;

public class Q64_Max_no_of_isands {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;

    }
    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;// not  grid[i][j] = '0';as its int int[][] grid

        return 1 + dfs(grid, i+1, j)
                + dfs(grid, i-1, j)
                + dfs(grid, i, j+1)
                + dfs(grid, i, j-1); // count current cell + all 4 directions
    }
}
