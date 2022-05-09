class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
        
        solve(digits, 0, "", ans);
        return ans;
    }
    
    public void solve(String digits, int idx, String str, List<String> ans){
        if(idx == digits.length()){
            ans.add(str);
            return;
        }
        int num = digits.charAt(idx)-'0';
        String s = getChar(num);
        
        for(int i=0;i<s.length();i++){
            solve(digits, idx+1, str+s.charAt(i), ans);
        }
        
    }
    
    public String getChar(int num){
        switch(num){
            case 2 : return "abc";
            case 3 : return "def";
            case 4 : return "ghi";
            case 5 : return "jkl";
            case 6 : return "mno";
            case 7 : return "pqrs";
            case 8 : return "tuv";
            case 9 : return "wxyz";
        }
        
        return "";
    }
    
}