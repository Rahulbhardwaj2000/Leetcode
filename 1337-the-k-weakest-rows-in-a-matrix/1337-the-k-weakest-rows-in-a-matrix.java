class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]==b[1]?a[0]-b[0] : a[1]-b[1]);
        int m = mat.length, n = mat[0].length;
        int[] strength = new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1) strength[i] += 1;
            }
            pq.add(new int[]{i, strength[i]});
        }
        int[] ans = new int[k];
        int i=0;
        while(k>0){
            ans[i] = pq.poll()[0];
            k--;
            i++;
        }
        
        return ans;
    }
}