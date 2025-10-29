class Solution {
    public class Pair{
        int i;
        int j;
        int distance;
        
        Pair(int i , int j , int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] ans = new int[m][n];
        Queue<Pair> que = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0 ; i< m ; i++){
            for(int j = 0;  j< n ; j++){
                if(mat[i][j] == 0){
                    que.add(new Pair(i, j , 0));
                    visited[i][j] = true;
                }
            }
        }
        
        while(que.size() > 0){
            Pair curr = que.remove();
            int i = curr.i;
            int j = curr.j;
            int distance = curr.distance;
            
             ans[i][j] = distance;
            
            // Check 4 directions
            if(i-1 >= 0 && !visited[i-1][j]){
                que.add(new Pair(i-1 , j , distance + 1));
                visited[i-1][j] = true;
            }
            
            if(i+1 < m && !visited[i+1][j]){
                que.add(new Pair(i+1 , j , distance + 1));
                visited[i+1][j] = true;
            }
            
            if(j-1 >= 0 && !visited[i][j-1]){
                que.add(new Pair(i , j-1 , distance + 1));
                visited[i][j-1] = true;
            }
            
            if(j+1 < n && !visited[i][j+1]){
                que.add(new Pair(i , j+1 , distance + 1));
                visited[i][j+1] = true;
            }
        }
        
        return ans;
    }
}