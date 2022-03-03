class Solution {
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]) continue;
            bfs(isConnected, i, vis);
            count += 1;
        }
        
        return count;
    }
    
    public void bfs(int[][] isConnected, int i, boolean[] vis){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            int rn = queue.remove();
            if(vis[rn]) continue;
            vis[rn] = true;
            
            for(int j=0;j<isConnected.length;j++){
                if(j!=rn && isConnected[rn][j] == 1){
                    isConnected[rn][j] = 0;
                    isConnected[j][rn] = 0;
                    queue.add(j);
                }
            }
        }
    }
}