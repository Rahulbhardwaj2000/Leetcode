class Solution {
    public int minimumEffortPath(int[][] heights) {
        int minc = Integer.MAX_VALUE;
        
        boolean[][] vis = new boolean[heights.length][heights[0].length];
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->a.cost-b.cost);
        queue.add(new Pair(0, 0, 0));
        
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        
        while(!queue.isEmpty()) {
            Pair rn = queue.poll();
            if(vis[rn.x][rn.y]) continue;
            vis[rn.x][rn.y] = true;
            
            if(rn.x == heights.length-1 && rn.y == heights[0].length-1){
                minc = Math.min(rn.cost, minc);
                continue;
            } 
            
            for(int i=0;i<dir.length;i++){
                int nx = rn.x + dir[i][0];
                int ny = rn.y + dir[i][1];
                if(nx<0 || ny<0 || nx>=heights.length || ny >= heights[0].length) continue;
                if(vis[nx][ny]) continue;
                
                int c = Math.abs(heights[rn.x][rn.y] - heights[nx][ny]);
                queue.add(new Pair(nx, ny, Math.max(rn.cost, c)));
            }
            
        }
        
        return minc;
    }
}

class Pair { // pos: x,y & maxcost_of_path: cost
    int x;
    int y;
    int cost;
    
    public Pair(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}