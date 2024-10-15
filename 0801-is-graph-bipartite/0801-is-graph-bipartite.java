class Solution {
    static class Edge{
        int src ;
        int nbr ;
        int wt;
        Edge(int src , int nbr , int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public class Pair {
        int v;
        String psf ;
        int level;

        Pair(int v , String psf , int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        List<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
               adj[i].add(new Edge(i, graph[i][j], 0));  
            }
        }
        int[] visited = new int[n]; 
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                if (!checkCompForBipartite(adj, i, visited)) {
                    return false;
                }
            }
        }

        return true;
        
    }

    public boolean checkCompForBipartite(List<Edge>[] graph , int src , int[] visited){
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src+"" , 0));
        
         while (!q.isEmpty()) {
            Pair rem = q.removeFirst();

            if(visited[rem.v] != -1){
                if(rem.level != visited[rem.v]){
                    return false;
                }
            }else{
                visited[rem.v] = rem.level;
            }
            for(Edge e : graph[rem.v]){
                if(visited[e.nbr] == -1){
                    q.add(new Pair(e.nbr , rem.psf + e.nbr , rem.level+1));
                }
            }
        }
        return true;
    }
}