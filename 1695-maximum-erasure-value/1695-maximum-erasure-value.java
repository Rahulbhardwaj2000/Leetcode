class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // kind of same as longest substring without repeating characters
        int sum = 0, res = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int i=0, j=0;
        while(j < nums.length){
            if(!set.contains(nums[j])){
                sum += nums[j];
                res = Math.max(res, sum);
                set.add(nums[j]);
                j++;
            }else{
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        
        return res;
    }
}