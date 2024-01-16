class Solution {
    public void setZeroes(int[][] matrix) {
        // Brute Force -> TC - O(n*m)*(n+m) + (n*m) = n^3  , SC - O(1)
        /*
        for(int i = 0; i < matrix.length; i++) { 
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for(int k = 0; k < matrix.length; k++) {
            for(int n = 0; n < matrix[0].length; n++) {
                if(matrix[k][n] == -1) {
                    matrix[k][n] = 0;
                }
            }
        }
        */


        
        // BETTER APPROACH -> TC - O(2*m*n) , SC - O(m) + O(n)
        int m = matrix.length;
        int n = matrix[0].length;
        int[] col = new int[n];
        int[] row = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        


        // OPTIMISED APPROACH ->TC - O() SC -O()
        
    }


    /*
    void markRow(int[][] matrix, int i) {
        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }

    void markCol(int[][] matrix, int j) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][j] != 0) {
                matrix[i][j] = -1;
            }
        }
    }
    */
}


