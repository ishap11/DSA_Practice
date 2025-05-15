class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];

        solve(board , 0 , cols , ndiag , rdiag ,  res);
        return res;
    }


    public void solve( boolean[][] board , int row ,  boolean[] cols  , boolean[] ndiag , boolean[] rdiag , List<List<String>> res) {


        if (row == board.length) {
            // Base case: If all rows are filled, add the current board configuration to the result
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j]) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                solution.add(sb.toString());
            }
            res.add(solution);
            return;
        }

        for(int col = 0;  col < board[0].length ; col++) {
            if(cols[col] == false && ndiag[row + col ]  == false && rdiag[row - col + board.length -1] == false) {
                board[row][col] = true;
                cols[col] = true;
                ndiag[row + col ] = true;
                rdiag[row - col + board.length -1] = true;

                solve(board, row + 1, cols, ndiag, rdiag, res);

                board[row][col] = false;
                cols[col] = false;
                ndiag[row + col ] = false;
                rdiag[row - col + board.length -1] = false;

            }  
        }
    } 
}