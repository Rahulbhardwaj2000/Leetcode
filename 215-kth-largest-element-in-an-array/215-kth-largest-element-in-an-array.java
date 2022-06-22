class Solution {
    public int findKthLargest(int[] nums, int k) {
        int ans = -1;
        k = nums.length-k;
        int lo = 0, hi = nums.length-1;

        while(lo <= hi){
            int idx = partition(nums, k, lo, hi);
            ans = nums[idx];
            if(k < idx){
                hi = idx-1;
            }else if(k > idx){
                lo = idx+1;
            }else{
                break;
            }
        }
        
        return ans;
    }
    
    public int partition(int[] nums, int k, int lo, int hi){
        int piv = nums[hi];
        int i=lo, j=lo;
        while(i<=hi){
            if(nums[i]<=piv){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
        }
        
        return j-1;
    }
    
}