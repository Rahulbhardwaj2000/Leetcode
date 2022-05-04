class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // number, frequency
        int count = 0;
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(k-nums[i])){
                System.out.println(k-nums[i] + "  idx: " + i);
                count += 1;
                int freq = map.get(k-nums[i]);
                
                if(freq == 1) map.remove(k-nums[i]);
                else map.put(k-nums[i], freq-1);
                
            }else map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        return count;
    }
}