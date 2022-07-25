class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int idx = -1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid] < target) lo = mid+1;
            else if(nums[mid] > target) hi = mid-1;
            else {idx = mid; break;}
        }
        
        if(idx == -1) return new int[]{-1, -1};
        
        int i=idx, j=idx;
        while(i>=0 && nums[i] == target){
            i--;
        }
        while(j<nums.length && nums[j] == target){
            j++;
        }
        
        return new int[]{i+1, j-1};
    }
}