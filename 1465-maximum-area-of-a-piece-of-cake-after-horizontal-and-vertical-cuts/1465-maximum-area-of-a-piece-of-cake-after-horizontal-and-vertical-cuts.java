class Solution {
    static int mod = 1000000007;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long maxh = Math.max(0, horizontalCuts[0]);
        for(int i=1;i<horizontalCuts.length;i++){
            maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i-1]);
        }
        maxh = Math.max(maxh, h-horizontalCuts[horizontalCuts.length-1]);
        
        long maxw = Math.max(0, verticalCuts[0]);
        for(int j=1;j<verticalCuts.length;j++){
            maxw = Math.max(maxw, verticalCuts[j] - verticalCuts[j-1]);
        }
        maxw = Math.max(maxw, w-verticalCuts[verticalCuts.length-1]);
        
        return (int)((maxh * maxw)%mod);
    }
}