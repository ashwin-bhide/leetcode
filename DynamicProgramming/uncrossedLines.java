class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        //DP - tabulation method
        int[][] dp = new int[m+1][n+1];
        
        int i=1,j=1;
        for(i=1;i<=m;i++){
            for(j=1;j<=n;j++){
                if(A[i-1] == B[j-1]) //since original arrays are zero based, we do i-1 and j-1
                    dp[i][j] = 1 + dp[i-1][j-1]; //diagonal element
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); //Max of top and left element
            }
        }
        return dp[m][n]; //last element of table
    }
}
