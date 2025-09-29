class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j<m ; j++){
                if (board[i][j] == word.charAt(0)) {
                    if (isPathExist(board, word, visited, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPathExist(char[][] board , String word , boolean[][] visited , int row , int col , int idx){
        if(idx == word.length()) return true;


        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }
        visited[row][col] = true;

        if (isPathExist(board, word, visited, row - 1, col, idx + 1) ||  // top
            isPathExist(board, word, visited, row, col - 1, idx + 1) ||  // left
            isPathExist(board, word, visited, row + 1, col, idx + 1) ||  // down
            isPathExist(board, word, visited, row, col + 1, idx + 1)) {  // right
            return true;
        }

        visited[row][col] = false;
        return false;
    }
}