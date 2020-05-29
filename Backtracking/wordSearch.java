class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0)
            return false;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(existHelper(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    private boolean existHelper(char[][] board,String word,int r,int c,int index){
        //base condition
        if(index==word.length())
            return true;
        
        boolean isFound;
        
        //constraint
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!=word.charAt(index))
            return false;
        
        //choose
        char temp = board[r][c];
        board[r][c] = ' ';
        //explore
        isFound = existHelper(board,word,r+1,c,index+1)
            || existHelper(board,word,r-1,c,index+1)
            || existHelper(board,word,r,c+1,index+1)
            || existHelper(board,word,r,c-1,index+1);
                
        //unchoose
        board[r][c] = temp;
        
        return isFound;
    }
}
