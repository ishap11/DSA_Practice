class Solution {
    boolean hasPath(ArrayList<Integer>[] graph, int src, int dest, boolean[] visited) {

       if(src == dest){
           return true;
       }
       visited[src] = true;
       for(int node : graph[src]){
           if(visited[node] == false){
               boolean hasNodePath = hasPath(graph, node, dest, visited);
               if(hasNodePath== true){
                   return true;
                }
            }
        }
       return false;
    }
   public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i =0 ; i<n ; i++){
           graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
           graph[edges[i][0]].add(edges[i][1]);
           graph[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];
        return hasPath(graph, source, destination , new boolean[n]);
   }
  
}