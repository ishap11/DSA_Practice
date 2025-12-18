class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    numOfIsland(grid , i , j , vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void numOfIsland(char[][] grid , int i , int j , int[][] vis){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || vis[i][j] == 1){
            return;
        }

        vis[i][j] = 1;
        numOfIsland(grid , i - 1 , j , vis);
        numOfIsland(grid , i + 1 , j , vis);
        numOfIsland(grid , i , j - 1 , vis);
        numOfIsland(grid , i , j + 1 , vis);
    }
}