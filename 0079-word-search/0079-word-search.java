class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start backtracking if the first character matches
                if (board[i][j] == word.charAt(0)) {
                    if (IsPathExist(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    public boolean IsPathExist(char[][] board, String word,boolean[][] visited , int row , int col ,int index ) {

        if (index == word.length()) {
            return true;
        }
        
       if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;

        if (IsPathExist(board, word, visited, row - 1, col, index + 1) ||  // top
            IsPathExist(board, word, visited, row, col - 1, index + 1) ||  // left
            IsPathExist(board, word, visited, row + 1, col, index + 1) ||  // down
            IsPathExist(board, word, visited, row, col + 1, index + 1)) {  // right
            return true;
        }

        visited[row][col] = false;
        return false;
    }
}