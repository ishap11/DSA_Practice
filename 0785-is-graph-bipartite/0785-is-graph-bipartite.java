class Solution {
    class Pair{
        int v;
        int level;

        Pair(int v , int level){
            this.v = v;
            this.level = level;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int[] vis = new int[V];
        Arrays.fill(vis , -1);

        for(int v = 0 ; v < V ; v++){
           if (vis[v] == -1) {
                if (!checkComponent(graph, v, vis)) {
                    return false;
                }
            }
        }
        return true; 
    }

    public boolean checkComponent(int[][] graph , int src , int[] vis){
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src , 0 ));

        while(que.size() > 0){
            Pair rem = que.remove();

            if(vis[rem.v] != -1){
                if(vis[rem.v] != rem.level){
                    return false;
                }
                continue;
            }

            vis[rem.v] = rem.level;


            for(int nbr : graph[rem.v]){
                if (vis[nbr] == -1) {
                    que.add(new Pair(nbr, rem.level + 1));
                }
            }
        }
        return true;
    }
}