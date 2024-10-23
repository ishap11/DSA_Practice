class Solution {
    public class Pair{
        int x;
        int y;
        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        LinkedList<Pair> queue = new LinkedList<>();

        for(int i=0; i< grid.length ; i++){
            for(int j=0 ; j< grid[0].length ; j++){
                if(grid[i][j] == 1) {
                    queue.addLast(new Pair(i,j));
                }else {
                    grid[i][j] = -1;
                }
            }
        }
       if (queue.isEmpty() || queue.size() == grid.length * grid[0].length) {
            return -1;
        }
        
        int[][] dirs = {{-1 ,0 } , { 1,0} , { 0, -1} , { 0, 1}};
        int level = -1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;

            while(size-- > 0){
                Pair rem  = queue.removeFirst();
                for(int i=0; i< dirs.length ; i++){
                    int rowdash = rem.x + dirs[i][0];
                    int coldash = rem.y + dirs[i][1];

                    if(rowdash >= 0 && coldash >= 0 && rowdash < grid.length && coldash < grid[0].length && grid[rowdash][coldash]  == -1){
                        grid[rowdash][coldash] = grid[rem.x][rem.y] + 1;
                        queue.addLast(new Pair(rowdash, coldash));
                    }
                }
            }
        }
        return level;
    }
}