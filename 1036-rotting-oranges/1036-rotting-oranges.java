class Solution {
    public class Pair{
        int row;
        int col ; 

        Pair(int row , int col ){
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        LinkedList<Pair> queue = new LinkedList<>();
        int time = 0;

        for(int i=0; i< m ; i++){
            for(int j= 0; j< n ; j++){
                if(grid[i][j] == 2){
                    queue.addLast(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    time++;
                }
            }
        }

        if(time == 0){
            return 0;
        }
        int[][] direction = {{-1 ,0 }, {0,1} , {1,0} , {0,-1}};
        int level = -1;
        // bfs
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;

            while(size-- > 0){
                Pair rem = queue.removeFirst();
                for(int i=0; i< 4 ; i++){
                    int rdash  = rem.row + direction[i][0];
                    int cdash = rem.col + direction[i][1];

                    if(rdash >=0 && cdash >= 0 && rdash < m && cdash < n && grid[rdash][cdash] == 1){
                        queue.addLast(new Pair(rdash, cdash));
                        grid[rdash][cdash] = 0;
                        time--;
                    }
                }
            }
        }

        if(time == 0){
            return level;
        }else{
            return -1;
        }
    }
}