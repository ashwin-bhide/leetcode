class Solution {
    public void rotate(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        
        if(nRows==0)
            return;
        
        //compute transpose in place 
        for(int r=0;r<nRows;r++){
            for(int c=r;c<nCols;c++){ //important, inner loop starts from c=r
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
        //reverse each row
        for(int r=0;r<nRows;r++){
            for(int c=0;c<nCols/2;c++){ //reverse only till mid index, otherwise it will re-reverse 
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][nCols-1-c]; //nCols-1, to get index of last element of the row
                matrix[r][nCols-1-c] = temp;
            }
        }
    }
}
