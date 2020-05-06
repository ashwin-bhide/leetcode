class Solution {
    //here we assume that the given board is solvable
    //we use backtracking to reduce our decision set and reach a solution
    List<Set<Character>> rows;
    List<Set<Character>> columns;
    List<Set<Character>> boxes;
    public void solveSudoku(char[][] board) {
        rows = new ArrayList();
        columns = new ArrayList();
        boxes = new ArrayList();
        
        for(int i=0;i<board.length;i++){
            rows.add(new HashSet<Character>());
            columns.add(new HashSet<Character>());
            boxes.add(new HashSet<Character>());
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int boxNo = (i/3)*3 + (j/3);
                char c = board[i][j];
                if(c != '.'){
                    rows.get(i).add(c);
                    columns.get(j).add(c);
                    boxes.get(boxNo).add(c);
                }
            }
        }
        
        solveSudokuHelper(board,0,0); //start from top left corner
    }
    private boolean solveSudokuHelper(char[][] board,int row,int col){
        //base condition
        if(col == board[0].length){ //we have reached end of row, so reset column index & increment row index
            col = 0;
            row++;
            
            if(row == board.length)
                return true; //board is solved
        }
        //skip if current cell is already filled
        if(board[row][col]!='.')
            return solveSudokuHelper(board,row,col+1);
        
        
        //determine box number
        int boxNo = (row/3)*3 + col/3;
        //decision: at each cell, we need to fill numbers 1-9, given that they satisfy the 3 constraints
        for(int i=1;i<=9;i++){
            char d = (char)(i + '0'); 
            //check constraints
            if(canPlaceValue(board,row,col,d)){
                board[row][col] = d; //choose
                rows.get(row).add(d);
                columns.get(col).add(d);
                boxes.get(boxNo).add(d);
                if(solveSudokuHelper(board,row,col+1))
                    return true; //explore
                board[row][col] = '.'; //unchoose
                rows.get(row).remove(d);
                columns.get(col).remove(d);
                boxes.get(boxNo).remove(d);
            }
        }
        return false;
    }
    private boolean canPlaceValue(char[][] board,int row,int col,char d){
        int boxNo = (row/3)*3 + col/3;
        if(rows.get(row).contains(d) || columns.get(col).contains(d) || boxes.get(boxNo).contains(d))
            return false;
        return true;
    }
}
