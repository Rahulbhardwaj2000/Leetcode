class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] strg = new int[text1.length()+1][text2.length()+1];
        return lcs(text1, text2, strg);
    }
    
    public int lcs(String s1, String s2, int[][] strg) {
        if(s1.length() == 0 || s2.length() == 0) return 0;
        
        if(strg[s1.length()][s2.length()] > 0) return strg[s1.length()][s2.length()];
        
        int l = 0;
        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);
        if(ch1 == ch2){
             l = lcs(s1.substring(1), s2.substring(1), strg) + 1;
        }
        l = Math.max(l, lcs(s1.substring(1), s2, strg));
        l = Math.max(l, lcs(s1, s2.substring(1), strg));
        
        strg[s1.length()][s2.length()] = l;
        return l;
    }
}