package NeetCode_150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q65_Pacafic_atlantic_water_flow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int[][] pacific=new int[heights.length][heights[0].length];
        int[][] atlantic=new int[heights.length][heights[0].length];

        //top and bottom
        for(int col=0;col<heights[0].length;col++){
            dfs(heights,0,col,Integer.MIN_VALUE,pacific);
            dfs(heights,heights.length-1,col,Integer.MIN_VALUE,atlantic);

        }
        // left and right
        for(int row=0;row<heights.length;row++){
            dfs(heights,row,0,Integer.MIN_VALUE,pacific);
            dfs(heights,row,heights[0].length-1,Integer.MIN_VALUE,atlantic);

        }
        //compare two matrix
        ArrayList<List<Integer>> res= new ArrayList<List<Integer>>();
        //iteration and find common elements
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    LinkedList<Integer> sol=new LinkedList<Integer>();
                    sol.add(i);
                    sol.add(j);
                    res.add(sol);
                }
            }
        }
        return res;

    }
    private static void dfs(int[][] heights, int row, int col, int prevval, int[][] ocean){
        // check nescerrary conditions
        if(row<0 || col<0 || row>heights.length-1 ||col>heights[0].length-1){
            return;
        }else if(heights[row][col]< prevval){
            return;
        }else if(ocean[row][col]==1){
            return;
        }
        //process cell
        ocean[row][col]=1;
        //call dfs as needed
        dfs(heights,row-1,col,heights[row][col],ocean);
        dfs(heights,row+1,col,heights[row][col],ocean);
        dfs(heights,row,col-1,heights[row][col],ocean);
        dfs(heights,row,col+1,heights[row][col],ocean);

    }
}
