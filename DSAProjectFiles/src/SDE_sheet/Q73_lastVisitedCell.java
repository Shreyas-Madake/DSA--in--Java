package SDE_sheet;

public class Q73_lastVisitedCell {
    public int[] lastVisitedCell(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];

        visited[0][0]=true;
        return dfs(0,0,grid,visited,n,m);
    }
    public int[] dfs(int r, int c, char[][] grid,boolean[][] visited,int n, int m){
        char d=grid[r][c];
        int nr=r;
        int nc=c;
        if(d=='L') nc--;
        else if(d=='R') nc++;
        else if(d=='U') nr--;
        else if(d=='D') nr++;
        if(nr<0|| nr>=n|| nc<0||nc>=m ||visited[nr][nc]){
            return new int[]{r,c};
        }
        visited[nr][nc]=true;
        return dfs(nr,nc,grid,visited,n,m);

    }
}
