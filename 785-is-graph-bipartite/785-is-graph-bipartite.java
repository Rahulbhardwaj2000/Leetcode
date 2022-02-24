class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean[] vis = new boolean[graph.length];
        int[] color = new int[graph.length];
        
        for(int i=0;i<graph.length;i++){
            if(vis[i]) continue;
            if(!solve(graph, vis, i, color)) return false;
        }
        return true;
    }
    
    public boolean solve(int[][] graph, boolean[] vis, int src, int[] color){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0}); // node, color(0 and 1)
        while(!queue.isEmpty()){
            int[] rn = queue.remove();
            if(vis[rn[0]]){
                if(color[rn[0]] != rn[1]) return false;
            }
            vis[rn[0]] = true;
            color[rn[0]] = rn[1]; 
            
            for(int nbr : graph[rn[0]]){
                if(vis[nbr]) continue;
                queue.add(new int[]{nbr, 1-rn[1]});
            }
        }
        
        return true;
    }
}