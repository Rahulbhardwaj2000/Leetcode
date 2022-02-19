class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxh = new PriorityQueue<>((a,b)->b-a);
        int min = Integer.MAX_VALUE, ans = Integer.MAX_VALUE;
        
        // First make all odd nos even by doubling so that we get idea about the MIN value
        for(int n : nums){
            if(n%2 == 0){
                min = Math.min(min, n);
                maxh.add(n);
            }
            else{
                min = Math.min(min, 2*n);
                maxh.add(2*n);
            }
        }
        
        while(maxh.peek()%2==0){
            int rv = maxh.poll();
            ans = Math.min(ans, rv-min);
            min = Math.min(min, rv/2); // new value may get lesser than MIN value
            maxh.add(rv/2);
        }
        
        return Math.min(ans, maxh.peek()-min);
    }
}