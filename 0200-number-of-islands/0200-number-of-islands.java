class Solution {
    public int numIslands(char[][] grid) {
        int count =  0;

        int n = grid.length ;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for(int i = 0; i< n ; i++){
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    findIsland(grid , i , j , visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void findIsland(char[][] grid , int i , int j , int[][] visited){
        if(i<0 || j<0|| i>= grid.length || j>= grid[0].length || grid[i][j] == '0' || visited[i][j] == 1){
            return;
        }

        visited[i][j] = 1;

        findIsland(grid , i-1 , j , visited);
        findIsland(grid , i+1 , j , visited);
        findIsland(grid , i , j-1 , visited);
        findIsland(grid , i , j+1 , visited);

    }
}