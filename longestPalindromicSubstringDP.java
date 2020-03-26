class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        int maxLength = 1; //single character is always palindrome
        int start = 0;
        
        //2 base cases for DP solution
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        //we have checked for substring of length 2, now start from 3
        for(int k=3;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                int j=i+k-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(k>maxLength){
                        maxLength = k;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}
