class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int ans = 0;
        while(i<j){
            int wid = j-i;
            int ht = Math.min(height[i], height[j]);
            ans = Math.max(ans, wid*ht);
            
            if(height[i]<=height[j]) i++;
            else j--;
        }
        
        return ans;
    }
}