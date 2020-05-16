class Solution {
    //let us use BFS approach, and topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses]; //maintain indegree of each node
        Map<Integer,List<Integer>> graph = new HashMap();
        //initialize graph
        for(int i=0;i<numCourses;i++)
            graph.put(i,new ArrayList<Integer>());
        
        Deque<Integer> q = new ArrayDeque(); //will contain next nodes to visit, having inDegree=0
        Set<Integer> visited = new HashSet(); //maintains visited node set
        
        for(int[] p:prerequisites){
            int course = p[0];
            int prereq = p[1]; //has outgoing edge to course
            graph.get(prereq).add(course);
            inDegree[course]++; //has incoming edge from prereq
        }
        //add nodes having inDegree=0 to queue
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)
                q.offer(i);
        }
        int[] result = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            visited.add(n);
            result[index++] = n;
            //visit all adjacent nodes
            List<Integer> children = graph.get(n);
            for(int child:children){
                inDegree[child]--;
                if(!visited.contains(child) && inDegree[child]==0) //add node to visit if it's inDegree=0
                    q.offer(child);
            }
        }
        return index==numCourses;
        
        
    }
}
