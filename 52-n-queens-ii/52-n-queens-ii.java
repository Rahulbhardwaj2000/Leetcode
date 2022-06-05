class Solution {
    public int totalNQueens(int n) {
        int[] count = {0};
        int[][] board = new int[n][n];
        solve(board, 0, 0, n, count, 0);
        return count[0];
    }
    
    public void solve(int[][] board, int cr, int cc, int n, int[] count, int qpsf){
        if(qpsf == n){
            count[0] += 1;
            return;
        }
        if(cc == n){
            cc = 0;
            cr += 1;
        }
        if(cr == n){
            return;
        }
        if(isValid(n, cr, cc, board)){
            board[cr][cc] = 1;
            solve(board, cr, cc+1, n, count, qpsf+1);
            board[cr][cc] = 0;
        }
        
        solve(board, cr, cc+1, n, count, qpsf);
    }
    
    public boolean isValid(int n, int cr, int cc, int[][] board){
        for(int i=0;i<n;i++){
            if(board[i][cc] == 1) return false;
        }
        for(int j=0;j<n;j++){
            if(board[cr][j] == 1) return false;
        }
        for(int i=cr+1,j=cc+1;i<n && j<n;i++,j++){
            if(board[i][j] == 1) return false;
        }
        for(int i=cr-1,j=cc-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 1) return false;
        }
        for(int i=cr-1,j=cc+1;i>=0 && j<n;i--,j++){
            if(board[i][j] == 1) return false;
        }
        for(int i=cr+1,j=cc-1;i<n && j>=0;i++,j--){
            if(board[i][j] == 1) return false;
        }
        return true;
    }
    
}