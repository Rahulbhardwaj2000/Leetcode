class Solution {
    public int numberOfSteps(int num) {
        if(num == 0) return 0;
        int ct = 0;
        while(num > 1) {
            if(num%2 != 0){
                ct += 1;
            }
            ct+=1;
            num/=2;
        }
        
        return ct+1;
    }
}