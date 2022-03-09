class Solution {
    static int mod = 1000000007;
    public int countOrders(int n) {
        int[][] pd = new int[2][n];
        // no. of pickups left, and no. of deliveries left
        
        long[][] strg = new long[n+1][n+1];
        solve(pd, 0, n, n, 0, strg); 
        
        return (int)strg[n][0]%mod;
    }
    
    public long solve(int[][] pd, int completed, int n, int nopl, int nodl, long[][] strg){
        if(completed == n){
            strg[nopl][nodl] = (strg[nodl][nopl] + 1)%mod;
            return strg[nopl][nodl];
        }
        
        if(strg[nopl][nodl]>0){
            return strg[nopl][nodl];
        }
        
        long ct = 0;
        // picking up a delivery
        for(int i=0;i<n;i++){
            if(pd[0][i]==0){
                pd[0][i] = 1;
                ct += solve(pd, completed, n, nopl-1, nodl+1, strg);
                pd[0][i] = 0;
            }
        }
        
        // delivering
        for(int i=0;i<n;i++){
            if(pd[0][i]==1 && pd[1][i]==0){
                pd[1][i] = 1;
                ct += solve(pd, completed+1, n, nopl, nodl-1, strg);
                pd[1][i] = 0;
            }
        }
        
        ct %= mod;
        strg[nopl][nodl] = ct;
        return ct;
    }
}