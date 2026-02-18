class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int minr = 0;
        int maxr = m - 1;

        int minc = 0;
        int maxc = n - 1;

        int tne = m * n;
        int cnt = 0;

        while(cnt < tne){
            for(int i = minc ; i <= maxc && cnt < tne ; i++){
                ans.add(matrix[minr][i]);
                cnt++;
            }
            minr++;

            for(int i = minr ; i <= maxr && cnt < tne ; i++){
                ans.add(matrix[i][maxc]);
                cnt++;
            }
            maxc--;

            for(int i = maxc ; i >= minc && cnt < tne ; i--){
                ans.add(matrix[maxr][i]);
                cnt++;
            }
            maxr--;

            for(int i = maxr; i >= minr && cnt < tne ; i--){
                ans.add(matrix[i][minc]);
                cnt++;
            }
            minc++;
        }

        return ans;
    }
}