class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if(n==0) return matrix;

        int minr = 0; //min row
        int minc = 0; //min column
        int maxr = n-1; //max row
        int maxc = n-1; // max column
        int tne = n*n; //tnc = total no. of element
        int count = 1; // Corrected: Start count from 1

        while(count <= tne) {
            for(int j= minc ; j<= maxc ; j++) {
                matrix[minr][j] = count++;
            }
            minr++;

            for(int i = minr ; i<= maxr ; i++) {
                matrix[i][maxc] = count++;
            }
            maxc--;

            for(int j = maxc ; j>=minc ; j--){ // Corrected: No need for count < tne check here
                matrix[maxr][j] = count++;
            }
            maxr--;

            for(int i = maxr ; i>=minr ; i--){ // Corrected: No need for count < tne check here
                matrix[i][minc] = count++;
            }
            minc++;
        }
        return matrix;
    }
}