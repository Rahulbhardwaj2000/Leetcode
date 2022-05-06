class Solution {
    public String removeDuplicates(String s, int k) {
        int i=0, n = s.length();
        int[] count = new int[n];
        StringBuilder sb = new StringBuilder(s);
        for(int j=0;j<n;i++,j++){
            sb.setCharAt(i, sb.charAt(j));
            count[i] = i>0 && sb.charAt(i)==sb.charAt(i-1) ? count[i-1]+1 : 1;
            if(count[i] == k) i-= k;
        }
        
        return sb.substring(0, i).toString();
    }
    
}