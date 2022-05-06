class Solution {
    public String removeDuplicates(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && (int)ch == stack.peek()){
                stack.pop();
            }else{
                stack.push((int)ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append((char)(stack.pop() + 'a' - 'a'));
        }
        
        return sb.reverse().toString();
    }
}