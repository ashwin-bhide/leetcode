class Solution {
    public class Orange{
        int row;
        int col;
        int layer;
        public Orange(int r,int c,int l){
            this.row=r;
            this.col=c;
            this.layer=l;
        }
    }
    public int orangesRotting(int[][] grid) {
        final int EMPTY = 0;
        final int FRESH = 1;
        final int ROT = 2;
        
        final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1,0},
            new int[]{-1,0},
            new int[]{0,1},
            new int[]{0,-1}
        );
        
        if(grid==null || grid.length==0)
            return -1;
        
        int m=grid.length;
        int n=grid[0].length;
        
        int result = 0;
        Queue<Orange> rotten = new LinkedList<Orange>(); //for BFS
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j] == ROT)
                    rotten.add(new Orange(i,j,0)); //initially, rotten orange is at layer 0
            }
        
        while(!rotten.isEmpty()){
                Orange o = rotten.poll();
                result = Math.max(result,o.layer);
                int currR = o.row;
                int currC = o.col;
                for(int[] direction:DIRECTIONS){
                    int r = currR+direction[0];
                    int c = currC+direction[1];
                
                    if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=FRESH)
                        continue;
                
                    grid[r][c] = ROT;
                    rotten.add(new Orange(r,c,o.layer+1));
                }   
            
        }
        //check if any frsh orange still remains
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j] == FRESH)
                    return -1;
            }
        
        return result;
    }
}
