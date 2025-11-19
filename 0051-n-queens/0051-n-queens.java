class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n - 1];
        boolean[] rdiag = new boolean[2*n - 1];

        List<List<String>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(n, 0, cols, ndiag, rdiag, ans, temp);
        return ans;
    }

    public void solve(int n, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag,
                      List<List<String>> ans, List<Integer> temp) {

        if (row == n) {
            ans.add(buildBoard(temp, n));   // convert col positions → strings
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cols[col] && !ndiag[row + col] && !rdiag[row - col + n - 1]) {

                temp.add(col);  // store column index (0-based)
                cols[col] = true;
                ndiag[row + col] = true;
                rdiag[row - col + n - 1] = true;

                solve(n, row + 1, cols, ndiag, rdiag, ans, temp);

                temp.remove(temp.size() - 1);
                cols[col] = false;
                ndiag[row + col] = false;
                rdiag[row - col + n - 1] = false;
            }
        }
    }

    // Convert list of queen positions into board representation
    private List<String> buildBoard(List<Integer> temp, int n) {
        List<String> board = new ArrayList<>();
        for (int col : temp) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == col) row.append('Q');
                else row.append('.');
            }
            board.add(row.toString());
        }
        return board;
    }
}
