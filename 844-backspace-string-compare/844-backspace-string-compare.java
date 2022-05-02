class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i=s.length()-1, j=t.length()-1;
        int scount = 0, tcount = 0;
        
        while(i>=0 || j>=0){
            
            while(i>=0 && (s.charAt(i) == '#' || scount>0)){
                if(s.charAt(i)=='#') scount++;
                else scount--;
                
                i -= 1;
            }
            
            while(j>=0 && (t.charAt(j) == '#' || tcount>0)){
                if(t.charAt(j)=='#') tcount++;
                else tcount--;
                
                j -= 1;
            }
            
            if(i<0 && j<0) return true;
            
            if(i<0 && j>=0){
                if(t.charAt(j) == '#') continue;
                return false;
            }
            
            if(j<0 && i>=0){
                if(s.charAt(i) == '#') continue;
                return false;
            }   
            
            if(s.charAt(i) != t.charAt(j)) return false;
            System.out.println(s.charAt(i) + ", " + t.charAt(j));
            
            i--;
            j--;
            
        }
        
        return true;
    }
}