class Solution {
    //clasicall dp problem
    //aka levenshtien distance
    //solve using tabulation(bottom-up method)
    public int minDistance(String word1, String word2) {
        int d = word2.length(); //destination word for rows
        int s = word1.length(); //source word for columns
        
        int[][] dp = new int[d+1][s+1];
        dp[0][0] = 0;
        
        for(int i=1;i<=d;i++)
            dp[i][0] = i;
        
        for(int j=1;j<=s;j++)
            dp[0][j] = j;
        
        for(int i=1;i<=d;i++)
            for(int j=1;j<=s;j++){
                if(word2.charAt(i-1)!=word1.charAt(j-1))
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                else
                    dp[i][j] = dp[i-1][j-1];
            }
        
        return dp[d][s];
        
    }
}
