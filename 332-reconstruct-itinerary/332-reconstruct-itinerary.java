class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, Boolean> start = new HashMap<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        
        // code for finding the starting node
        for(int i=0;i<tickets.size();i++){
            List<String> flight = tickets.get(i);
            String src = flight.get(0);
            String dest = flight.get(1);
            start.put(dest, false);
            if(!start.containsKey(src)){
                start.put(src, true);
            }
            
            //making adjacency list
            if(!map.containsKey(src)){
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).add(dest);
        }
        
        
        String beg = "";
        for(String str : start.keySet()){
            if(start.get(str)){
                beg = str;
                break;
            }
        }
        
        Stack<String> stack = new Stack<>();
        if(beg.length()==0){
            stack.push("JFK");
        }else stack.push(beg);
        
        List<String> ans = new ArrayList<>();
        
        while(!stack.isEmpty()){
            String city = stack.peek();
            
            PriorityQueue<String> pq = map.get(city);
            
            if(!map.containsKey(city) || pq.size() == 0){
                ans.add(city);
                stack.pop();
            }else{
                stack.push(pq.peek());
                pq.poll();
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}