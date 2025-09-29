class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int minr = 0;
        int maxr = matrix.length - 1;

        int minc = 0;
        int maxc = matrix[0].length - 1;

        int tne = n * m;
        int count = 0;

        while(count < tne){
            for(int j = minc ; j<= maxc && count < tne; j++){
                ans.add(matrix[minr][j]);
                count++;
            }
            minr++;

            for(int i = minr ; i <= maxr && count < tne; i++){
                ans.add(matrix[i][maxc]);
                count++;
            }
            maxc--;

            for(int j = maxc ; j>= minc && count < tne; j--){
                ans.add(matrix[maxr][j]);
                count++;
            }
            maxr--;

            for(int i = maxr ; i>= minr && count < tne; i--){
                ans.add(matrix[i][minc]);
                count++;
            }
            minc++;
        }

        return ans;
    }
}