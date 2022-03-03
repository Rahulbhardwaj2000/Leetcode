class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count = 0, diff = 0, ans = 0;
        
        for(int j=1;j<nums.length;j++){
            int d = nums[j] - nums[j-1];
            if(d == diff){
                count++;
            }else{
                if(count>=2){
                    count -= 1;
                    ans += (count*(count+1))/2;
                }
                count = 1;
                diff = d;
            }
        }
        
        if(count>=2){
            count -= 1;
            ans += (count*(count+1))/2;
        }
        
        return ans;
    }
}