class Solution {
    public String removeDuplicates(String s) {
        // 2 pointer approach
        int i=0, n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int j=0; j<n; i++, j++){
            sb.setCharAt(i, sb.charAt(j));
            if(i > 0 && sb.charAt(i) == sb.charAt(i-1)){
                i -= 2;
            }
        }
        
        return sb.substring(0, i).toString();
    }
}