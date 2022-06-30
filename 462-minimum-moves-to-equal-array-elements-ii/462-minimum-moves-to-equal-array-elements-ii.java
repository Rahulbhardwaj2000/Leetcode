class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        // like meeting point problem
        // basically getting the difference from Median will give the answer reqd.
        int count = 0, i=0, j=nums.length-1;
        while(i<j){
            count += nums[j] - nums[i];
            // = (nums[j] - nums[mid]) + (nums[mid] - nums[i]) = nums[j] - nums[i]
            i++;
            j--;
        }
        
        return count;
    }
}