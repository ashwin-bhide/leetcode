class Solution {
    public class HeightComparator implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
            return a[2] - b[2];   
        }
    }
    public int cutOffTree(List<List<Integer>> forest) {
        int r = forest.size();
        int c = forest.get(0).size();
        
        
        PriorityQueue<int[]> pq = new PriorityQueue(new HeightComparator());
        
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                if(forest.get(i).get(j)>1)
                    pq.offer(new int[]{i,j,forest.get(i).get(j)});
        
        int distance = 0;
        int sx = 0, sy = 0;
        while(!pq.isEmpty()){
            int[] tree = pq.poll();
            int tx = tree[0];
            int ty = tree[1];
            //steps required to reach tree from sx, sy
            int steps = bfs(forest,sx,sy,tx,ty);
            if(steps<0)
                return -1; //tree unreachable from current location
            else{
                sx = tx;
                sy = ty;
                distance += steps;
            }
        }
        return distance;
    }
    private int bfs(List<List<Integer>> forest,int sx,int sy,int tx,int ty){
        int r = forest.size();
        int c = forest.get(0).size();
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[r][c];
        int[] start = new int[]{sx,sy};
        
        q.offer(start);
        visited[sx][sy] = true;
        int step = 0;
        
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i=0;i<qsize;i++){
                int[] node = q.poll();
                int x = node[0];
                int y = node[1];
                
                if(x==tx && y==ty)
                    return step;
                
                for(int[] d:dir){
                    int nx = x+d[0];
                    int ny = y+d[1];
                    if(nx>=0 && ny>=0 && nx<r && ny<c && !visited[nx][ny] && forest.get(nx).get(ny)!=0){
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true; //mark visited immediately to avoid TLE
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
