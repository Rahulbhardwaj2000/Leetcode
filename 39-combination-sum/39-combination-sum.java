class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // important to sort the array first
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        solve(candidates, target, new ArrayList<>(), ans, 0);
        return ans;
    }
    
    public void solve(int[] candidates, int target, List<Integer> list, List<List<Integer>> ans, int idx){   
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=idx;i<candidates.length && target-candidates[i]>=0;i++){
            list.add(candidates[i]);
            solve(candidates, target - candidates[i], list, ans, i);
            list.remove(list.size()-1);
        }
        
    }
}