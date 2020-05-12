class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,List<Integer>> graph;
        Set<Integer> visited = new HashSet();
        graph = createGraph(edges);
        return dfs(graph,hasApple,visited,0,0); //cost of visiting current node(current node is at 0) is 0
    }
    private Map<Integer,List<Integer>> createGraph(int[][] edges){
        //it is an undirected graph, so bi-directional edges need to be recorded, edge from A->B as well as from B->A
        Map<Integer,List<Integer>> g = new HashMap();
        for(int[] edge:edges){
            //A->B
            List<Integer> adjList = g.getOrDefault(edge[0],new ArrayList<Integer>());
            adjList.add(edge[1]);
            g.put(edge[0],adjList);
            
            //B->A
            adjList = g.getOrDefault(edge[1],new ArrayList<Integer>());
            adjList.add(edge[0]);
            g.put(edge[1],adjList);
        }
        return g;
    }
    private int dfs(Map<Integer,List<Integer>> graph,List<Boolean> hasApple,Set<Integer> visited,int currNode,int cost){
        //base case
        if(visited.contains(currNode))
            return 0;
        visited.add(currNode);
        
        int adjNodeCost = 0;
        //visit all connected nodes
        for(int adjNode:graph.getOrDefault(currNode,new ArrayList<>())){
            adjNodeCost += dfs(graph,hasApple,visited,adjNode,2);
        }
        
        //when we reach leaf node, and it does not contain an apple, return 0
        if(adjNodeCost==0 && hasApple.get(currNode) == false)
            return 0;
        
        return cost+adjNodeCost;
    }
}
