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
        if(root==null)
            return null;
        
        //level 1 done
        if(root.left!=null)
            root.left.next = root.right;
        
        Node leftMost = root.left;
        while(leftMost!=null){
            Node curr = leftMost;
            while(curr!=null){ //connect right pointers for current level
                if(curr.left!=null){
                    curr.left.next = curr.right;
                    if(curr.next!=null){
                        curr.right.next = curr.next.left;
                    }  
                }
                curr = curr.next; 
            }
            leftMost = leftMost.left; //move to next level
        }
        return root;
    }
}
