class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hs = new HashSet<String>();
        for(String w:wordDict)
            hs.add(w);
        
        boolean[] matrix = new boolean[s.length()+1];
        matrix[0] = true;
        //len = length of substring in s, so if s=leetcode, then we check for lengths 1,2,3,4,5,6,7,8
        for(int len=1;len<=s.length();len++){
            for(int i=0;i<len;i++){
                /* for len = 1, we check dp[0] && */
                if(matrix[i] && hs.contains(s.substring(i,len))){
                    matrix[len] = true;
                    break;
                }
            }
        }
        return matrix[s.length()];
    }
}
