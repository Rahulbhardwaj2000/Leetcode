class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), k, n, 0, 1);
        return ans;
    }
    
    public void solve(List<List<Integer>> ans, List<Integer> comb, int k, int n, int cs, int idx){
        if(k == 0 && cs == n){
            ans.add(new ArrayList<>(comb));
            return;
        }
        if(k == 0){
            return;
        }
        for(int i=idx;i<10;i++){
            if(cs+i <= n){
                comb.add(i);
                solve(ans, comb, k-1, n, cs+i, i+1);
                comb.remove(comb.size()-1);
            }
        }
    }
}