package DailyLeetcode;

public class Q2_countIslands {
    public int countIslands(int[][] grid, int k) {
        int n= grid.length;
        int m=grid[0].length;
        int cnt=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    if(dfs(grid,i,j,n,m) % k==0){
                        cnt++;
                    }
                }
            }
        }
        return cnt;

    }
    /// note vvi in this i got integer overflow as 2 test cases doest passed
    //so in this case use long instad of int eg: public long dfs() and everting inside it be it long
    public long dfs(int[][] grid,int r,int c,int n,int m){
        if(r<0|| r>=n || c<0 || c>=m || grid[r][c]==0 ) return 0;

        long value=grid[r][c];
        grid[r][c]=0; // this is to mark as visited
        long sum=value;
        sum+= dfs(grid,r+1,c,n,m) +  dfs(grid,r-1,c,n,m) +  dfs(grid,r,c+1,n,m) +  dfs(grid,r,c-1,n,m);

        return sum;

    }
}
