class Solution {
    public class Pair{
        int i;
        int j;
        int time;

        Pair(int i , int j , int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> que = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];

        int ans = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    que.add(new Pair(i , j , 0));
                    vis[i][j] = true; 
                }
            }
        }

        while(que.size() > 0){
            Pair rem = que.remove();
            int i = rem.i;
            int j = rem.j;
            int time = rem.time;

            ans = Math.max(ans , time);

            if(i-1 >= 0 && !vis[i-1][j] && grid[i-1][j] == 1){
              que.add(new Pair(i-1 , j , time + 1));
              vis[i-1][j] = true;
            }

            if(i+1 < m && !vis[i+1][j] && grid[i+1][j] == 1){
              que.add(new Pair(i+1 , j , time + 1));
              vis[i+1][j] = true;
            }

            if(j-1 >= 0 && !vis[i][j-1] && grid[i][j-1] == 1){
              que.add(new Pair(i , j-1 , time + 1));
              vis[i][j-1] = true;
            }

            if(j+1 < n && !vis[i][j+ 1] && grid[i][j + 1] == 1){
              que.add(new Pair(i , j + 1 , time + 1));
              vis[i][j+1] = true;
            }
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0;  j < n ; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }

        return ans;
    }
}