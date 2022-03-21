class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        
        int[] alpha = new int[26];
        // store end indexes of characters
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a'] = i;
        }
        
        int start = 0, end = 0;
        for(int i=0;i<s.length();i++){
            end = Math.max(end, alpha[s.charAt(i)-'a']);
            // if i reaches the ending of first interval, it means any character that has occured
            // till now will not come ahead (otherwise i would not have reached end here)
            if(i==end){
                ans.add(end-start + 1);
                start = i+1;
            }
        }
        
        return ans;
    }
}