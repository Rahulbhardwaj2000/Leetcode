class NumMatrix {
    
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        if((matrix == null) || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        // prefix is of size m+1, n+1 so that calculating prefix for i=0 & j=0 can easily happen
        prefix = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);

        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);
        
        return prefix[iMax + 1][jMax + 1] - prefix[iMax + 1][jMin] - prefix[iMin][jMax + 1] + prefix[iMin][jMin];    
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */