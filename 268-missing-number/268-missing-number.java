class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, num = 0;
        for(int i=0;i<=n;i++) num = num^i;
        for(int val : nums) num = num^val;
        
        return num;
    }
}