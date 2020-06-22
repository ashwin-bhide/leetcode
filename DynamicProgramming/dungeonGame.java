class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        int[][] dp = new int[row][col];
        //start from destination(bottom-right) to source(0,0)
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i==row-1 && j==col-1)
                    dp[i][j] = dungeon[i][j]<0?Math.abs(dungeon[i][j])+1:1; //if value is positive, Knight just needs to be alive ie have energy = 1
                
                else if(i==row-1) //last row; minimum energy to move to right 
                    dp[i][j] = Math.max(dp[i][j+1] - dungeon[i][j],1);
                
                else if(j==col-1) //last col; minimum energy to move down
                    dp[i][j] = Math.max(dp[i+1][j] - dungeon[i][j],1);
                
                else //find minimum of down and right
                    dp[i][j] = Math.max((Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j]),1);
            }
        }
        
        return dp[0][0];
    }
}
