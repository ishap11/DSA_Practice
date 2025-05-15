class Solution {
    public void solveSudoku(char[][] board) {
        solve(board , 0,0);
    }

   public boolean solve(char[][] board, int i, int j) {
        if (i == board.length) {
            return true;
        }

        int ni = 0;
        int nj = 0;
        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != '.') {
            return solve(board, ni, nj);
        } else {
            for (char po = '1'; po <= '9'; po++) {
                if (isValid(board, i, j, po)) {
                    board[i][j] = po;
                    if (solve(board, ni, nj)) {
                        return true;
                    }
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    public static boolean isValid(char[][] board, int x, int y, char val) {
        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == val) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == val) {
                return false;
            }
        }

        int submatrixi = x / 3 * 3;
        int submatrixj = y / 3 * 3;
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n < 3; n++) {
                if (board[submatrixi + m][submatrixj + n] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}