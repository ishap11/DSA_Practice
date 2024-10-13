class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];

        for(int i=0; i< n  ;i++){
            for(int j=0; j< m ; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    int area = island(grid , i, j , visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int island(int[][] grid , int i , int j, int[][] visited){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || visited[i][j] == 1){
        return 0 ;
    }

        visited[i][j] = 1;
        int area = 1;
        area += island(grid, i - 1, j, visited); // North
        area += island(grid, i, j + 1, visited); // East
        area += island(grid, i + 1, j, visited); // South
        area += island(grid, i, j - 1, visited); // West

        return area;
    }
}