package NeetCode_150;

public class Q58_Word_search {
    boolean visited[][];


    public boolean exist(char[][] board, String word) {
        int rows=board.length;
        int colums=board[0].length;
        visited=new boolean[rows][colums];
        for(int i=0;i<rows;i++){
            for(int j=0;j<colums;j++){
                if(word.charAt(0)==board[i][j] && exist(i,j,0,word,board)){
                    return true;
                }
            }


        }
        return false;

    }
    public boolean exist(int i,int j, int index,String word, char[][] board){
        if(index==word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[i].length|| word.charAt(index)!=board[i][j] || visited[i][j]){
            return false;
        }
        visited[i][j]=true;
        if(exist(i+1,j,index+1,word,board)||
                exist(i-1,j,index+1,word,board)||
                exist(i,j+1,index+1,word,board)||
                exist(i,j-1,index+1,word,board)
        ){
            return true;
        }
        visited[i][j]=false;
        return false;
    }
}
