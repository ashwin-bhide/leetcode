class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms==null || rooms.length==0)
            return;
        
        final int EMPTY = Integer.MAX_VALUE;
        //Instead of starting from empty rooms, we start from gates and fill the distance to its nearest empty room
        
        final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] {1,0},
            new int[] {-1,0},
            new int[] {0,1},
            new int[] {0,-1}
        );
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        //add all gates first
        Queue<int[]> visited = new LinkedList<int[]>();
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0)
                    visited.add(new int[]{i,j});
            }
        
        while(!visited.isEmpty()){
            int[] node = visited.poll();
            int currR = node[0]; //coordinates of current node
            int currC = node[1];
            for(int[] direction:DIRECTIONS){
                //we visit all 4 directions of cuurent node in this loop
                int r= currR+direction[0];
                int c= currC+direction[1];
                if(r<0 || c<0 || r>=m || c>=n || rooms[r][c]!=EMPTY)
                    continue;
                rooms[r][c] = rooms[currR][currC] + 1;
                visited.add(new int[]{r,c});
            }
        }
    }
}
