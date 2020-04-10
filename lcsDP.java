class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0) //if either(or both) string is empty, no common sequence 
            return 0;
        
        text1 = "x" + text1; //adding 1 extra col and 1 extra row for "" case
        text2 = "x" + text2;
        int t1Len = text1.length(); 
        int t2Len = text2.length();
        
        int[][] dp = new int[t1Len][t2Len];
        
        for(int r=1;r<t1Len;r++){
            for(int c=1;c<t2Len;c++){
                if(text1.charAt(r)==text2.charAt(c))
                    dp[r][c] = 1 + dp[r-1][c-1]; //diag left element ie, lcs(string) excluding the matched char
                else
                    dp[r][c] = Math.max(dp[r-1][c],dp[r][c-1]); 
            }
        }
        
        return dp[t1Len-1][t2Len-1];
    }
}
