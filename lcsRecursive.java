class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0) //if either(or both) string is empty, no common sequence 
            return 0;
        
        String t1WithoutLastChar = text1.substring(0,text1.length()-1);
        String t2WithoutLastChar = text2.substring(0,text2.length()-1);
        
        char t1LastChar = text1.charAt(text1.length()-1); // we start by comparing last char of the string
        char t2LastChar = text2.charAt(text2.length()-1); //if equal then 1+LCS(t1,t2), else Max()
        
        if(t1LastChar==t2LastChar)
            return 1 + longestCommonSubsequence(t1WithoutLastChar,t2WithoutLastChar);
        else
            return Math.max(longestCommonSubsequence(text1,t2WithoutLastChar),longestCommonSubsequence(t1WithoutLastChar,text2));
        
    }
}
