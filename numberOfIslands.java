class Solution {
    public int numIslands(char[][] grid) {
        int result=0;
        if(grid==null || grid.length==0)
            return 0;
        //iterate over each element in matrix
        for(int i=0;i<grid.length;++i){
            for (int j=0;j<grid[i].length;++j){
                if(grid[i][j]=='1'){
                    result++;
                    dfsFill(grid,i,j);
                }
            }
        }
        return result;
    }
    //this function performs dfs, ie visits all nodes connected to the grid[i,j](root node) and marks them as visited(converts to '0')
    public void dfsFill(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]=='0')
            return;
        
        grid[i][j]='0';
        
        dfsFill(grid,i-1,j);
        dfsFill(grid,i+1,j);
        dfsFill(grid,i,j-1);
        dfsFill(grid,i,j+1);
    }
}
