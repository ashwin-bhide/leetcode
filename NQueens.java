class Solution {
    public int totalNQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> colPlace = new ArrayList<Integer>();
        placeQueen(0,colPlace,result,n);
        return result.size();
    }
    private void placeQueen(int rowIndex,List<Integer> colPlace, List<List<Integer>> result, int n){
        //final state, terminating condition
        if(rowIndex==n)
            result.add(colPlace);
        
        for(int i=0;i<n;i++){
            //place queen in a column
            colPlace.add(i);
            //check if it is a valid placement
            if(isValid(colPlace)){
                //if it is valid, move to the next row
                placeQueen(rowIndex+1,colPlace,result,n);
            }
            //backtrack
            colPlace.remove(colPlace.size()-1);
        }
       
    }
    
    private boolean isValid(List<Integer> colPlace){
        //size of the list denotes the current row we are processing
        //we need to check all the above row placements
        int currRow = colPlace.size()-1;
        for(int i=0;i<currRow;i++){
            int diff = Math.abs(colPlace.get(currRow) - colPlace.get(i));
            //if difference is 0, means Q is placed in same column;
            //if difference == (difference between curr row id and i) it indicates 
            // we are in diagonal; suppose we are at row 2 and i=0
            // then (2,2) will be our diagonal
            if(diff==0 || diff==currRow-i)
                return false;
        }
        return true;
    }
}
