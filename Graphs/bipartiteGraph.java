class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        //bipartite graph problem
        //2 color graph
        //step 1: create adjacency list of undirected graph
        Map<Integer,List<Integer>> adjList = new HashMap();
        for(int i=1;i<=N;i++){
            adjList.put(i,new ArrayList());
        }
        for(int[] d:dislikes){
            adjList.get(d[0]).add(d[1]);
            adjList.get(d[1]).add(d[0]);
        }
        //step2: maintain colors array to check which nodes have been processed until now
        // and to ensure adjacent nodes do not have the same color
        //as there are 2 sets, we have 2 colors, 0 & 1
        int[] colors = new int[N+1];
        Arrays.fill(colors,-1);
        
        for(int i=1;i<=N;i++){
            //initialise BFS on each unvisited vertex
            if(colors[i]==-1)
                if(!isBipartite(adjList,colors,i))
                    return false;
        }
        return true;
    }
    private boolean isBipartite(Map<Integer,List<Integer>> adjList,int[] colors,int currNode){
        Queue<Integer> q = new LinkedList();
        colors[currNode] = 1; 
        q.offer(currNode);
        while(!q.isEmpty()){
            int node = q.poll();
            int currColor = colors[node];
            for(int nbr:adjList.get(node)){
                if(currColor==colors[nbr])
                    return false;
                if(colors[nbr]==-1){
                    colors[nbr] = 1-currColor;
                    q.offer(nbr);
                }
            }
        }
        return true;
    }
}
