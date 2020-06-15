class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] g = new int[n][n];
        
        for(int[] f:flights){
            g[f[0]][f[1]] = f[2];
        }
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        minHeap.offer(new int[]{0,src,K}); //cost,place,stops remaining
        
        while(!minHeap.isEmpty()){
            int[] node = minHeap.poll();
            int cost = node[0], place = node[1], stops = node[2];
            
            if(place == dst)
                return cost;
            
            if(stops >= 0){
                for(int i=0;i<n;i++){
                    if(g[place][i]>0)
                        minHeap.offer(new int[]{cost+g[place][i],i,stops-1});
                }
            }
        }
        return -1;
    }
}
