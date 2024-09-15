class Solution {
    int max = 0;
    
    public int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    List<Integer> bag = new ArrayList<>();
                    travelAndCollect(grid, i, j, visited, bag);
                }
            }
        }
        
        return max;
    }

    private void travelAndCollect(int[][] grid, int i, int j, boolean[][] visited, List<Integer> bag) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        bag.add(grid[i][j]);

        // Calculate the sum of the current path's gold
        int currentSum = 0;
        for (int val : bag) {
            currentSum += val;
        }
        max = Math.max(max, currentSum);

        travelAndCollect(grid, i, j - 1, visited, bag); // left
        travelAndCollect(grid, i, j + 1, visited, bag); // right
        travelAndCollect(grid, i - 1, j, visited, bag); // up
        travelAndCollect(grid, i + 1, j, visited, bag); // down

        bag.remove(bag.size() - 1);
        visited[i][j] = false;
    }
}
