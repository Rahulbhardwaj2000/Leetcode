class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int cc = i;
            for(int j=0;j<m;j++){
                int nc = cc + grid[j][cc];
                if(nc<0 || nc==n || grid[j][cc] != grid[j][nc]){
                    res[i] = -1;
                    break;
                }
                cc = nc;
            }
            if(res[i] != -1) res[i] = cc;
        }
        
        return res;
    }
}