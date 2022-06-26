class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += cardPoints[i];
        }
        int maxSum = sum;
        for(int i=0;i<k;i++){
            sum = sum - cardPoints[k-1-i] + cardPoints[cardPoints.length-1-i];
            maxSum = Math.max(maxSum, sum);
        }
        
        return maxSum;
    }
    
}