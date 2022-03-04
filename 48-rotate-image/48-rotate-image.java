class Solution {
    public void rotate(int[][] matrix) {
        // rotate = transpose(about top left to bottom right diagonal) + reflect about middle column
        int n = matrix.length;
        // tranpose
        for(int slide = 0;slide<n-1;slide++){
            for(int j=slide+1;j<n;j++){
                int temp = matrix[slide][j];
                matrix[slide][j] = matrix[j][slide];
                matrix[j][slide] = temp;
            }
        }
        
        // reflect
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        
    }
}