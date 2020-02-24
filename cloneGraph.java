/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        // vertexMap for maintaining mapping between original node and clone node
        // queue for BFS traversal, all neighbors of particular node are traversed first
        Map<Node,Node> vertexMap = new HashMap<Node,Node>();
        Queue<Node> q = new LinkedList<Node>();
        
        //add first node to queue, and put it in map
        q.add(node);
        vertexMap.put(node,new Node(node.val));
        
        //while q is not empty, ie all nodes in graph are not traversed
        while(!q.isEmpty()){
            Node currVertex = q.remove();
            //get the neighbors of cuurent Node, from original graph
            for(Node neighbor:currVertex.neighbors){
                if(!vertexMap.containsKey(neighbor)){
                    //if not present in map, add them
                    vertexMap.put(neighbor,new Node(neighbor.val));
                    q.add(neighbor);
                }
                //now neighbor mapping is present in map, so recreate the edges, get gives you value field
                // in hashmap, so we are adding neighbors to cloned node(in our value field)
                vertexMap.get(currVertex).neighbors.add(vertexMap.get(neighbor));
            }
        }
        return vertexMap.get(node);
        
    }
}
