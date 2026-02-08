class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                // 1️⃣ Destination
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                }

                // 2️⃣ Last row (except destination)
                else if (i == m - 1) {
                    dp[i][j] = 1;
                }

                // 3️⃣ Last column (except destination)
                else if (j == n - 1) {
                    dp[i][j] = 1;
                }

                // 4️⃣ Rest of grid
                else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}