class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int tne = m*n;
        int count  = 0;

        int minr = 0;
        int maxr = matrix.length - 1;

        int minc = 0;
        int maxc = matrix[0].length - 1;

        while(count < tne){
            for(int i = minc ; i <= maxc  && count < tne; i++){
                ans.add(matrix[minr][i]);
                count++;
            }
            minr++;

            for(int i  = minr ; i <= maxr  && count < tne; i++){
                ans.add(matrix[i][maxc]);
                count++;
            }
            maxc--;

            for(int i = maxc ; i>=minc && count < tne; i--){
                ans.add(matrix[maxr][i]);
                count++;
            }
            maxr--;

            for(int i = maxr ; i>=minr && count < tne ; i--){
                ans.add(matrix[i][minc]);
                count++;
            }
            minc++;
        }
        return ans;
    }

}