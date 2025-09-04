class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] chess = new int[n][n];

        nQueens(n , chess , ans , 0);
        return ans;
    }

    public void nQueens(int n , int[][] chess , List<List<String>> ans , int row ){
        List<Integer> res = new ArrayList<>();

        if(row == n){
            List<String> board = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(chess[i][j] == 1) sb.append('Q');
                    else sb.append('.');
                }
                board.add(sb.toString());
            }
            ans.add(board);
            return;
        }

        for(int col = 0; col < n;  col++){
            if(isSafePlace(chess , row , col)) {
                chess[row][col] = 1;
                nQueens(n , chess , ans , row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private boolean isSafePlace(int[][]chess , int row , int col){
        // check column
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 1) return false;
        }
        
        // upper-left diagonal
        for(int i = row - 1 , j = col - 1 ; i >= 0 && j >= 0 ; i-- , j--) {
            if(chess[i][j] == 1){
                return false;
            }
        }

        // upper-right diagonal
        for(int i = row - 1 , j = col + 1 ; i >= 0 && j < chess.length ; i-- , j++){
            if(chess[i][j] == 1){
                return false;
            }
        }

        return true;
    }
}