class Solution {
    public int totalNQueens(int n) {
        int[] count = {0}; 

        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];

        solve(board , 0 , cols , ndiag , rdiag , count);
        return count[0];
    }
    public void solve( boolean[][] board , int row ,  boolean[] cols  , boolean[] ndiag , boolean[] rdiag , int[] count) {
        
        if (row == board.length) {
            // Base case
            count[0]++;
            return;

        }

        for(int col =0 ; col < board[0].length ; col++){
            if(cols[col] == false && ndiag[row + col] == false && rdiag[row - col + board.length - 1] ==false){
                board[row][col] = true;
                cols[col] = true;
                ndiag[row+col] = true;
                rdiag[row - col + board.length - 1]  = true;

                solve(board, row + 1, cols, ndiag, rdiag, count);

                board[row][col] = false;
                cols[col] = false;
                ndiag[row+col] = false;
                rdiag[row - col + board.length - 1]  = false;

            }
        }
    }
}