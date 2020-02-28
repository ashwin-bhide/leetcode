/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root==null || (root.left==null && root.right==null))
           return root;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;++i){
                Node n = q.poll();
                if(i<size-1)
                    n.next = q.peek();
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
        }
        return root;
        
    }
}
