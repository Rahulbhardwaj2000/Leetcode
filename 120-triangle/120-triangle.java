class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        for(int i=0;i<dp.length;i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        
        for(int i=triangle.size()-2;i>=0;i--){
            List<Integer> list = triangle.get(i);
            for(int j=0;j<list.size();j++){
                dp[j] = Math.min(dp[j] , dp[j+1]) + list.get(j);
            }
        }
        
        return dp[0];
    }
    
}