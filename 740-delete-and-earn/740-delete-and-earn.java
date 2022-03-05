class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] dp = new int[n];
        for(int num : nums){
            dp[num] += num; // dp[num] will store the total points earned by removing all num
        }
        
        int incl = 0, excl = 0;
        for(int i=0;i<n;i++){
            int temp = incl;
            incl = Math.max(excl+dp[i], incl);
            excl = temp;
        }
        
        return incl;
    }
}