class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i=text1.length()-1;i>=0;i--){
            char ch1 = text1.charAt(i);
            for(int j=text2.length()-1;j>=0;j--){
                char ch2 = text2.charAt(j);
                
                int max = 0;
                if(ch1 == ch2){
                    max = dp[i+1][j+1] + 1;
                }else{
                    max = Math.max(max, dp[i+1][j]);
                    max = Math.max(max, dp[i][j+1]);
                }   
                
                dp[i][j] = max;
            }
        }
        
        return dp[0][0];
    }
}