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
    public int getHeight(TreeNode node){
        if(node==null) return -1;
        
        return 1+Math.max(getHeight(node.left),getHeight(node.right));
        
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        
        if(Math.abs(getHeight(root.left)-getHeight(root.right)) > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
}
