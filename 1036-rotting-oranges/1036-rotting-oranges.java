class Solution {
    static class Node{
        int i ;
        int j ;
        int time;

        Node(int i , int j , int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Node> que = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        for(int i = 0 ; i< m ; i++){
            for(int j = 0 ; j< n ;j++){
                if(grid[i][j] == 2){
                    que.add(new Node(i , j , 0));
                }
            }
        }

        while(que.size() > 0){
            Node curr = que.remove();
            int i = curr.i;
            int j = curr.j;
            int time = curr.time;

            ans = Math.max(ans , time);

            if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == 1){
                que.add(new Node(i-1 , j , time + 1));
                visited[i-1][j] = true;
            }

            if(i+1 < m && !visited[i+1][j] && grid[i+1][j] == 1){
                que.add(new Node(i+1 , j , time + 1));
                visited[i+1][j] = true;
            }


            if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == 1){
                que.add(new Node(i , j-1 , time + 1));
                visited[i][j-1] = true;
            }

            if(j+1 < n && !visited[i][j+1] && grid[i][j+1] == 1){
                que.add(new Node(i , j+1 , time + 1));
                visited[i][j+1] = true;
            }
        }

        for(int i = 0 ; i< m ; i++){
            for(int j = 0 ; j< n ;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    return -1;
                }
            }
        }

        return ans;
    }
}