class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){
            char ch = s.charAt(j);
            if(!map.containsKey(ch)){
                map.put(ch, j);
            }else{
                i = Math.max(i, map.get(ch) + 1); // v.v imp to use this max value here
                map.put(ch, j);
            }
            len = Math.max(len, j-i+1);
            j++;
        }
        
        return len;
    }
}