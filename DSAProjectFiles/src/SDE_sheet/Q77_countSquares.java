package SDE_sheet;

public class Q77_countSquares {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j]=matrix[i][j];
                }
                else if(matrix[i][j]==0){
                    dp[i][j]=0;
                }
                else{
                    dp[i][j]=1+ Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                }
                sum+=dp[i][j];
            }
        }
        return sum;

    }
}
