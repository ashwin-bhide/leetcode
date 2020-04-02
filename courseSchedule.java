class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create adjacency list to maintain neighbors of each vertex;
        Map<Integer,List<Integer>> hm = new HashMap<>();
        //array for keeping inDegree of each vertex, we could use map as well
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        int resIndex = 0;
        for(int[] pr:prerequisites){
            int dest = pr[0];
            int src = pr[1];
            
            List<Integer> destList = hm.getOrDefault(src,new ArrayList<Integer>());
            destList.add(dest);
            hm.put(src,destList);
            
            inDegree[dest]++; //in degree is number of incoming edges at a vertex
                                //ie [0,1] [1,2] [3,1] then count of js in [i,j]
            
        }
        LinkedList<Integer> q = new LinkedList<>(); //q for keeping vertex with inDegree = 0
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)
                q.add(i);
        
        while(!q.isEmpty()){
            int node = q.poll();
            result[resIndex++] = node;
            //find neighbors of node decrement their inDegree, as we are removing node from graph
            if(hm.containsKey(node)){
                for(int neighbor:hm.get(node)){
                    inDegree[neighbor]--;
                    
                    if(inDegree[neighbor]==0)
                        q.add(neighbor);
                }
            }
 
        }
        if(resIndex == numCourses)
            return result;
        else 
            return new int[0];
    }
}
