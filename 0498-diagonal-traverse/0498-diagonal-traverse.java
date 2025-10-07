class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] ans = new int[n*m];

        boolean up = true;
        int i = 0;
        int j = 0;
        int k = 0;

        while(k < n * m){
            ans[k++] = mat[i][j];

            if(up){
                if(j == m - 1){
                    i++;
                    up = false;
                }else if(i == 0){
                    j++;
                    up = false;
                }else{
                    i--;
                    j++;
                }
            }else{
                if(i == n - 1){
                    j++;
                    up = true;
                }
                else if(j == 0){
                    i++;
                    up = true;
                }else{
                    i++;
                    j--;
                }
            }
             //if (i >= n || j >= m) break;
        }
        return ans;
    }
}