class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) return 0;
        
        int start = nums.length, end = 0;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] > nums[i]){
                start = i-1;
                break;
            }
            if(i == nums.length-1) return 0;
        }
        
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] > nums[i+1]){
                end = i+1;
                break;
            }
        }
        
        // now find the min and max in this unsorted region
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        for(int i=0;i<start;i++){
            if(nums[i] > min){ // if find number greater than min, then have to sort from there
                start = i;
            }
        }
        
        for(int i=nums.length-1;i>end;i--){
            if(max > nums[i]){ // if find number smaller than max
                end = i; 
            }
        }
        
        return (end-start+1);
    }
}