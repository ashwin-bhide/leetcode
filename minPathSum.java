class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        
        int r = grid.length;
        int c = grid[0].length;
        
        int[][] dp = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                dp[i][j]+=grid[i][j]; //add grid[i][j] to current dp cell, for (0,0) none of below conditions satisfy, so it remains the same
                if(i>0 && j>0){
                    //we check min of top and left element
                    dp[i][j]+=Math.min(dp[i-1][j],dp[i][j-1]);
                } else if(j>0) //for first row elements, where r is not greater than 0
                    dp[i][j]+=dp[i][j-1];
                  else if(i>0) //for first column elements, where c is not greater than 0
                    dp[i][j]+=dp[i-1][j];
            }
        }
        return dp[r-1][c-1];
    }
}
