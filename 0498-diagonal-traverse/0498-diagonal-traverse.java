class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];

        int i = 0, j = 0, k = 0;
        boolean up = true;

        while (k < m * n) {
            ans[k++] = mat[i][j];

            if (up) { // moving up-right
                if (j == n - 1) {    // last column → move down
                    i++;
                    up = false;
                } else if (i == 0) { // first row → move right
                    j++;
                    up = false;
                } else {
                    i--;
                    j++;
                }
            } else { // moving down-left
                if (i == m - 1) {    // last row → move right
                    j++;
                    up = true;
                } else if (j == 0) { // first column → move down
                    i++;
                    up = true;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }
}
