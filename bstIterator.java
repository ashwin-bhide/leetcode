/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// We are using Inorder traversal with Explicit stack
class BSTIterator {
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        this.s = new Stack<TreeNode>();
        findLeftMostHelper(root);
    }
    //gives the leftmost child of a given node
    public void findLeftMostHelper(TreeNode node){
        while(node!=null){
            s.push(node);
            node=node.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode node = s.pop();
        //if node has right child, find the leftmost element in right subtree to get next node in Inorder
        if(node.right!=null)
            findLeftMostHelper(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return s.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
