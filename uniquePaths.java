class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length==0)
            return 0;
        
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        
        if(obstacleGrid[0][0]==1)
            return 0;
        
        obstacleGrid[0][0] = 1;
        
        for(int j=1;j<c;j++){ //setup first row
            obstacleGrid[0][j]=(obstacleGrid[0][j]==0 && obstacleGrid[0][j-1]==1)?1:0;
        }
        for(int i=1;i<r;i++){ //setup first column
          obstacleGrid[i][0]=(obstacleGrid[i][0]==0 && obstacleGrid[i-1][0]==1)?1:0;
        }
        
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(obstacleGrid[i][j]==1)
                    obstacleGrid[i][j]=0;
                else
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }
        }
        return obstacleGrid[r-1][c-1];
    }
}
