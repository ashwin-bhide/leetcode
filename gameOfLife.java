class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length==0) return;
        int rowCount = board.length;
        int colCount = board[0].length;
       
        for(int row=0;row<rowCount;row++){
            for(int col=0;col<colCount;col++){
                int oneCount=0;
                //find neighbour indices
                int nRowMin = (row-1<0)?0:row-1;
                int nRowMax = (row+1>rowCount-1)?rowCount-1:row+1;
                int nColMin = (col-1<0)?0:col-1;
                int nColMax = (col+1>colCount-1)?colCount-1:col+1;
                
                for(int i=nRowMin;i<=nRowMax;i++)
                    for(int j=nColMin;j<=nColMax;j++){
                        if(Math.abs(board[i][j]) == 1 && (i!=row || j!=col))
                            oneCount++;
                    }
                //rule 4 dead cell becomes live        
                if(board[row][col]==0 && oneCount==3)
                    board[row][col] = 2;
                //rule 1 and 3 live cell becomes dead(-1 indicates it's dead now, but originally was alive)
                if((board[row][col]==1) && (oneCount<2 || oneCount>3))
                    board[row][col] = -1;
                
            }
        }
        for(int row=0;row<rowCount;row++)
            for(int col=0;col<colCount;col++){
                if(board[row][col] <= 0)
                    board[row][col] = 0;
                else
                    board[row][col] = 1;
            }
    }
}
