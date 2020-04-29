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
    public TreeNode invertTree(TreeNode root) {
        //base case
        if(root==null || (root.left==null && root.right==null))
            return root;
        
        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;
        
        root.left = invertTree(rightTree);
        root.right = invertTree(leftTree);
        
        return root;
    }
}
