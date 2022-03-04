class Solution {
    public void rotate(int[][] matrix) {
        /*
        // rotate = transpose (about top left to bottom right diagonal) + reflect (about middle column)
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
            for(int j=0;j<n/2;j++){ //important to keep it n/2 only here, even in case of EVEN length
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        */
        method2(matrix);
    }
    
    public void method2(int[][] matrix){ // needs to be performed on thsi particular order only
        int n = matrix.length;
        for(int i=0;i<(n/2 + n%2);i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
    
}