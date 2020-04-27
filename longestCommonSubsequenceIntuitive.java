class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 && text2.length()==0)
             return 0;
        int i = text1.length();
        int j = text2.length();
        int[][] memo = new int[i+1][j+1]; //add 1 more to row and column for handling base case in recursive function
        //set memo table to -1
        //last row and last column will remain 0 to handle base case
        for(int r=0;r<i;r++)
            for(int c=0;c<j;c++)
                memo[r][c] = -1;
        
        return lcsHelper(text1,text2,memo,0,0);
    }
    private int lcsHelper(String text1,String text2,int[][] memo,int i, int j){
        //base case
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = 1+lcsHelper(text1,text2,memo,i+1,j+1);
            return memo[i][j];
        } else{
            memo[i][j] = Math.max(lcsHelper(text1,text2,memo,i+1,j),lcsHelper(text1,text2,memo,i,j+1));
            return memo[i][j];
        }
    }
    
    
 // *****  general recursive solution *****
//     public int longestCommonSubsequence(String text1, String text2) {
//         if(text1.length()==0 && text2.length()==0)
//             return 0;
        
//         return lcsHelper(text1,text2,0,0);
//     }
//     private int lcsHelper(String text1,String text2,int index1,int index2){
//         //base case
//         //if either of the strings is finished, there is nothing to compare
//         if(index1==text1.length() || index2==text2.length())
//             return 0;
        
//         //if chars are equal, increment both indices
//         if(text1.charAt(index1)==text2.charAt(index2))
//             return 1+lcsHelper(text1,text2,index1+1,index2+1);
//         else //not equal, check by incrementing 1 index at a time
//             return Math.max(lcsHelper(text1,text2,index1+1,index2),lcsHelper(text1,text2,index1,index2+1));
//     }
}
