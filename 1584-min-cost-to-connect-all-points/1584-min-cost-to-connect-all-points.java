class Solution {
    public int minCostConnectPoints(int[][] points) {    
        int cost = 0;
        boolean[] vis = new boolean[points.length];
        
        // arr to track min edge wt to reach node i from any node already visited
        int[] minDist = new int[points.length]; 
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        
        int countEdgesVisited = 0;
        
        while(countEdgesVisited < points.length){
            int minWtEdge = Integer.MAX_VALUE;
            int node = -1;
            
            // getting the least weigted edge that is unvisited
            for(int i=0;i<points.length;i++){
                if(!vis[i] && minDist[i]<minWtEdge){
                    minWtEdge = minDist[i];
                    node = i;
                }
            }
            
            vis[node] = true;
            countEdgesVisited++;
            cost += minDist[node];
            
            // updating the distance from node to all its neighbouring nodes
            for(int i=0;i<points.length;i++){
                if(!vis[i]){
                    int[] pt = points[i];
                    int wt = Math.abs(pt[0]-points[node][0]) + Math.abs(pt[1]-points[node][1]);
                    if(wt < minDist[i]) minDist[i] = wt;
                }
            }
            
            
        }
        
        return cost;
    }
}