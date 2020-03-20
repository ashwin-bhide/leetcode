class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0)
            return false;
        int rStart = 0, cStart = 0;
        int rEnd = matrix.length, cEnd = matrix[0].length;
        //set initial pointer to bottom left of matrix
        int i = rEnd-1, j = cStart;
        while(i>=rStart && i<rEnd && j>=cStart && j<cEnd){
            if(target == matrix[i][j])
                return true;
            else if(target<matrix[i][j])
                i--;
            else
                j++;
        }
        return false;
        
    }
}
