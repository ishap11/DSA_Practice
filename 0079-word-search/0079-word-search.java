class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(board , word , i , j , vis , 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word , int i , int j , boolean[][] vis , int idx){
        if (idx == word.length()) {
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx) || vis[i][j] ){
            return false;
        }

        vis[i][j] = true;

        if( find(board , word , i - 1 , j , vis , idx + 1) ||
            find(board , word ,  i + 1 , j ,vis , idx + 1) ||
            find(board , word ,  i , j - 1 , vis , idx + 1) ||
            find(board , word ,  i , j + 1 ,vis , idx + 1) ){
                return true;
            }

        vis[i][j] = false;

        return false;
    }
}