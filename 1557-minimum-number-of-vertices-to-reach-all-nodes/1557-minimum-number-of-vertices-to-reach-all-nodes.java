class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new LinkedList<>();
        int[] indegree = new int[n];
        for(List<Integer> list : edges){
            indegree[list.get(1)] += 1;
        }
        for(int i=0;i<n;i++){
            if(indegree[i] == 0) ans.add(i);
        }
        
        return ans;
    }
}