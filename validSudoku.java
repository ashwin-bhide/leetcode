class Solution {
    List<Set<Integer>> rows;
    List<Set<Integer>> cols;
    List<Set<Integer>> boxes;
    public boolean isValidSudoku(char[][] board) {
        if(board.length==0)
            return false;
        
        rows = new ArrayList();
        cols = new ArrayList();
        boxes = new ArrayList();
        for(int i=0;i<board.length;i++){
            rows.add(new HashSet<Integer>());
            cols.add(new HashSet<Integer>());
            boxes.add(new HashSet<Integer>());
        }
        
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(board[i][j]!='.') 
                   if(!isValidRow(board,i,j) || !isValidCol(board,i,j) || !isValidBox(board,i,j))
                    return false;
        
        return true;
    }
    
    boolean isValidRow(char[][] board,int i,int j){
        int n = board[i][j] - '0';
        return rows.get(i).add(n);
        
    }
    
    boolean isValidCol(char[][] board,int i,int j){
        int n = board[i][j] - '0';
        return cols.get(j).add(n);
    }
                  
    boolean isValidBox(char[][] board, int i, int j){
        int n = board[i][j] - '0';
        int ri = i/3;
        int ci = j/3;
        int box = ri*3+ci;
        return boxes.get(box).add(n);
    }
    
}
