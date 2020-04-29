class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int maxSide = 0;
        int[][] dp = new int[r][c];
        //each cell of dp array stores the maximum subsquare side length
        //considering that cell represents bottom-right corner of the subsquare
        
        //initialize first row
        for(int i=0;i<c;i++){
            if(matrix[0][i]=='0')
                dp[0][i] = 0;
            else{
                dp[0][i] = 1;
                maxSide = 1;
            }
        }
        //initialise first column
        for(int i=0;i<r;i++){
            if(matrix[i][0]=='0')
                dp[i][0] = 0;
            else{
                dp[i][0] = 1;
                maxSide = 1;
            }
        }
        
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][j] == '0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = calculateMaxSide(dp,i,j);
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        
        return maxSide*maxSide;
    }
    private int calculateMaxSide(int[][] dp,int r,int c){
        int up = dp[r-1][c];
        int left = dp[r][c-1];
        int diag = dp[r-1][c-1];
        if(up == 0 || left ==0 || diag == 0)
            return 1;
        else
            return 1+Math.min(up,Math.min(left,diag));
    }
}
