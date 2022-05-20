class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int[][] grid = obstacleGrid;
        if(grid[grid.length-1][grid[0].length-1] == 1) return 0;
        
        int[][] dp = new int[grid.length][grid[0].length];
        
        for(int i=grid.length-1;i>=0;i--){
            for(int j=grid[0].length-1;j>=0;j--){
                if(i == grid.length-1 && j == grid[0].length-1){
                    dp[i][j] = 1;
                }else if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i == grid.length-1){
                    if(dp[i][j+1] != 0) dp[i][j] = dp[i][j+1];
                }else if(j == grid[0].length-1){
                    if(dp[i+1][j] != 0) dp[i][j] = dp[i+1][j];
                }else{
                    int ct = 0;
                    if(dp[i+1][j] != 0) ct += dp[i+1][j];
                    if(dp[i][j+1] != 0) ct += dp[i][j+1];
                    dp[i][j] = ct;
                }
            }
        }
        
        return dp[0][0];
    }
    
    
}