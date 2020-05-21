class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        int count = 0;
        //consider each cell as bottom-right of the subsquare
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                //first row and first col are border squares, so copy them as is
                if(i==0 || j==0){
                    if(matrix[i][j] == 1){
                        count++;
                    }
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                //as current cell matrix[i][j] is bottom-right of subsqaure
                //we compare values in top, left and diagonal element
                if(matrix[i][j] == 1){
                    int val = 1+findSquare(i,j,dp); //we add 1 for current cell(subsquare of side=1)
                    dp[i][j] = val;
                    count = count + val; 
                }
            }
        }
        return count;
    }
    private int findSquare(int i,int j,int[][] dp){
        int top = dp[i-1][j];
        int left = dp[i][j-1];
        int diag = dp[i-1][j-1];
        return Math.min(diag,Math.min(top,left));
    }
}
