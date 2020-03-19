class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix==null || matrix.length==0)
            return result;
        
        int last_row = matrix.length - 1;
        int last_col = matrix[0].length - 1;
        int r=0,c=0,i;
        
        while(r<=last_row && c<=last_col){
                //print first row
            for(i=c;i<=last_col;i++)
                result.add(matrix[r][i]);
            r++;            //indicates first row is done
                //print last column
            for(i=r;i<=last_row;i++)
                result.add(matrix[i][last_col]);
            last_col--;   //indicates last column is done
                //print last row
            if(r<=last_row){
                for(i=last_col;i>=c;i--)
                    result.add(matrix[last_row][i]);
                last_row--;
            }
                //print first column
            if(c<=last_col){
                for(i=last_row;i>=r;i--)
                    result.add(matrix[i][c]);
                c++;
            }      
        }
        return result;
    }
}
