class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch != '#'){
                stack1.push(ch);
                i++;
                continue;
            }
            if(!stack1.isEmpty() && ch == '#'){
                stack1.pop();
            }
            i++;
        }
        
        i=0;
        while(i<t.length()){
            char ch = t.charAt(i);
            if(ch != '#'){
                stack2.push(ch);
                i++;
                continue;
            }
            if(!stack2.isEmpty() &&ch == '#'){
                stack2.pop();
            }
            i++;
        }
        
        if(stack1.size() != stack2.size()){
            return false;
        }
        
        while(!stack1.isEmpty()){
            if(stack1.pop() != stack2.pop()) return false;
        }
        
        return true;
    }
}