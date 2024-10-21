class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for(int i=0; i< board.length ; i++){
            for(int j= 0; j< board[0].length  ;j++){
                if(i==0 || j ==0 || i == board.length-1 || j == board[0].length -1){
                    if(board[i][j] == 'O'){
                        dfs ( board , i, j);
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';  // Flip unmarked 'O' cells
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';  // Convert temporary marked cells back to 'O'
                }
            }
        }
    }
    public void dfs(char[][]  board , int i , int j ){
        if(i< 0 || j  < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return ;
        }
        board[i][j] = 'T';
        dfs(board , i+1 , j);
        dfs(board , i-1 , j);
        dfs(board , i , j+1);
        dfs(board , i , j-1);
    }
}