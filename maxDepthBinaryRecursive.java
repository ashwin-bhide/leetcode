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
    public int maxDepth(TreeNode root) {
        if(root == null) 
            return 0;
        else{
            int lht = maxDepth(root.left);
            int rht = maxDepth(root.right);
            return Math.max(lht,rht) + 1;
        }
            
    }
}
