class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    if (i == m - 1 || j == n - 1) {
                        dp[i][j] = 1; // bottom row or rightmost column
                    } else {
                        int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                        min = Math.min(min, dp[i + 1][j + 1]);
                        dp[i][j] = min + 1;
                    }
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans * ans; // area = side^2
    }
}
