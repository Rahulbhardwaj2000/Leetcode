class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue >= target) return startValue-target;
        int count = 0;
        
        while (target > startValue) {
            target = target % 2 > 0 ? target + 1 : target / 2;
            count++;
        }
        
        return count + startValue-target;
    }
}