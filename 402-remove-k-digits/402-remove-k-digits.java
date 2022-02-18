class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char ch : num.toCharArray()){
            int n = ch-'0';
            
            while(!stack.isEmpty() && stack.peek()>n && k>0){
                stack.pop();
                k -= 1;
            }
            
            if(!stack.isEmpty() || n!=0) stack.push(n);
        }
        
        while(!stack.isEmpty() && k>0){
            stack.pop();
            k -= 1;
        }
        
        if(stack.isEmpty()) return "0";
        
        while(!stack.isEmpty()){
            sb.insert(0, (char)(stack.pop()+'0'));
        }
        
        return sb.toString();
    }
}