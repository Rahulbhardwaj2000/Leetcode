class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int cost = 0;
        int[] start = points[0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        boolean[] vis = new boolean[points.length];
        pq.add(new int[]{start[0], start[1], 0, 0}); // x,y,cost, which point?
        
        while(!pq.isEmpty()){
            int[] rn = pq.poll();
            if(vis[rn[3]]) continue;
            vis[rn[3]] = true;
            cost += rn[2];
            
            for(int i=0;i<points.length;i++){
                if(vis[i]) continue;
                int[] pt = points[i];
                int dist = Math.abs(pt[0]-rn[0]) + Math.abs(pt[1]-rn[1]);
                pq.add(new int[]{pt[0], pt[1], dist, i});
            }
        }
        
        return cost;
    }
}