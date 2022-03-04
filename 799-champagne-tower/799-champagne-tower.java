class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] flow = new double[query_row+2][query_row+2];
        flow[0][0] = poured;
        
        for(int row=0;row<=query_row;row++){
            for(int col=0;col<=row;col++){
                double excess = (double)(flow[row][col]-1)/2;
                if(flow[row][col]>=1){
                    flow[row+1][col] += excess;
                    flow[row+1][col+1] += excess;
                }
            }
        }
        
        return Math.min(1, flow[query_row][query_glass]);
        // have to consider min of 1 and the value as the array contains the liquid_flow through
        // each glass which may be greater than 1, but we just need the amout of glass filled
    }
}