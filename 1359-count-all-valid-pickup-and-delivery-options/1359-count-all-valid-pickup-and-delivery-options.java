class Solution {
    // (1x2x3x4x....xn) x (1x3x5x7x....x2n-1)
    // pickups              deliveries
    public int countOrders(int n) {
        int mod = 1000000007;
        long ans = 1;
        for(int i=1;i<=n;i++){
            ans *= i;
            ans %= mod;
            ans *= (2*i-1);
            ans %= mod;
        }
        
        return (int)ans%mod;
    }
    
}