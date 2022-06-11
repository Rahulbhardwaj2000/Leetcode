class Solution {
    public int minOperations(int[] nums, int x) {
        // have to find the largest subarray with that target sum
        int target = 0;
        for(int i=0;i<nums.length;i++) target += nums[i];
        
        target -= x;
        
        // target 0 means the sum of whole array is equal to x
        if(target == 0) return nums.length;
        
        int len = Integer.MIN_VALUE;
        int presum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // this will help to give correct length for array starting from start index
        
        for(int i=0;i<nums.length;i++){
            presum += nums[i];
            if(map.containsKey(presum - target)){
                // length of subarray having sum = target
                //System.out.println(i-map.get(presum - target));
                len = Math.max(len, i-map.get(presum - target));
            }
            map.put(presum, i);
        }
        
        if(len == Integer.MIN_VALUE) return -1;
        
        return nums.length - len;
    }
    
}