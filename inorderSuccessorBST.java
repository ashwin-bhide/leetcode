/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null) return null;
        //if phas right child, then in BST, p's inorder sucessor will be the leftmost element in p's right subtree
        if(p.right!=null){
            p=p.right;
            while(p.left!=null)
                p=p.left;
            return p;
        }
        
        Stack<TreeNode> s = new Stack<>();
        
        while(!s.isEmpty() || root!=null){ //second condition is added to ensure that in first step, root is added to the stack
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root=s.pop();
            if(root.val>p.val)
                return root;
            root=root.right;
        }
        return null;
    }
}
