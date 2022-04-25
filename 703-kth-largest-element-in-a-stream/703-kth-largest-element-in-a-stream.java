class KthLargest {
    
    PriorityQueue<Integer> pq;
    int size;

    // keep adding element to a container of size k and keep removing smaller elements if required
    public KthLargest(int k, int[] nums) {
        pq  = new PriorityQueue<>();
        size = k;
        
        for(int val : nums) add(val);
    }
    
    public int add(int val) {
        if(pq.size() < size){
            pq.add(val);
        }else if(pq.peek() < val){
            pq.poll();
            pq.add(val);
        }
        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */