class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer,List<Integer>> adjList = new HashMap();
        Set<Integer> visited = new HashSet();
        
        for(int i=0;i<numCourses;i++)
            adjList.put(i,new ArrayList());
        
        for(int[] pr:prerequisites){
            int c = pr[0];
            int p = pr[1];
            
            adjList.get(p).add(c); //directed edge from prerequisite to course 
            inDegree[c]++; //incoming edge at course
            
        }
        
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0)
                topologicalSort(adjList,inDegree,visited,i);
        }
        
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]!=0)
                return false;
        }
        
        return true;
    }
    private void topologicalSort(Map<Integer,List<Integer>> adjList,int[] inDegree,Set<Integer> visited,int currNode){
        if(visited.contains(currNode))
            return;
        Queue<Integer> q = new LinkedList();
        q.offer(currNode);
        while(!q.isEmpty()){
            int node = q.poll();
            visited.add(node);
            for(int nbr:adjList.get(node)){
                inDegree[nbr]--;
                if(inDegree[nbr]==0 && !visited.contains(nbr))
                    q.offer(nbr);
            }
        }
    }
}
