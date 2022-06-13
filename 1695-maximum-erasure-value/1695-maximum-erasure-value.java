class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // kind of same as longest substring without repeating characters
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // number, index
        int[] prefix = new int[nums.length+1];
        
        for(int i=1;i<=nums.length;i++){
            prefix[i] = nums[i-1] + prefix[i-1];
        }
        
        int i=0, j=0;
        while(j < nums.length){
            
            if(map.containsKey(nums[j])){
                int cs = prefix[j] - prefix[i];
                sum = Math.max(sum, cs);
                i = Math.max(i, map.get(nums[j])+1); // new start of the unique subarray
            }
            
            map.put(nums[j], j);
            j++;
        }
        
        int cs = prefix[j] - prefix[i];
        sum = Math.max(sum, cs);
        
        return sum;
    }
}