class Solution {
    int max =  0;

    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i< n  ; i++){
            for(int j = 0 ; j< m ; j++){
                if(grid[i][j] != 0){
                    List<Integer> bagOfGold = new ArrayList<>();
                    travelAndCollectGold(grid , i , j , visited , bagOfGold);
                }
            }
        }
        return max;
    }

    public void travelAndCollectGold(int[][] grid , int i , int j , boolean[][] visited ,  List<Integer> bagOfGold){
        if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return;
        }

        visited[i][j] = true;
        bagOfGold.add(grid[i][j]);
        int currSum  = 0;

        for(int val : bagOfGold){
            currSum += val;
        }

        max = Math.max(max , currSum);

        travelAndCollectGold(grid, i, j - 1, visited, bagOfGold); // left
        travelAndCollectGold(grid, i, j + 1, visited, bagOfGold); // right
        travelAndCollectGold(grid, i - 1, j, visited, bagOfGold); // up
        travelAndCollectGold(grid, i + 1, j, visited, bagOfGold); // down

        bagOfGold.remove(bagOfGold.size() - 1);
        visited[i][j] = false;
    }
}