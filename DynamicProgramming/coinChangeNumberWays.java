class Solution {
    public int change(int amount, int[] coins) {
        //bottom-up dp - tabulation method
        //2 choices at each step - include the coin; exclude the coin (add the two values to get total ways)
        
        int[][] dp = new int[coins.length+1][amount+1];
        
        //first column
        for(int i=0;i<dp.length;i++)
            dp[i][0] = 1; //1 way to make zero amount ie by exluding the coin
        
        //first row, excluding first element
        for(int i=1;i<dp[0].length;i++)
            dp[0][i] = 0; //o ways to make any amount(eg. from 1 to 5) with no coins
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j < coins[i-1]) //if current sub-amount ie 1,2,3,4,5 is less than current coin denomination; exclude current coin denomination, ie move upward
                    dp[i][j] = dp[i-1][j];
                else                //sum of including the coin (move left in same row) + excluding the coin
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
            }
        }
        //return last element of matrix
        return dp[coins.length][amount];
    }
}
