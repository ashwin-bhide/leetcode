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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base cases
        if(root==null)
            return null;
        if(root==p || root==q)
            return root;
        
        //we keep on searching, going down the tree until our base cases are hit
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);
        
        //once the recursion returns ie, base cases are hit, we check for our conditions
        if(leftTree!=null && rightTree!=null)
            return root; //voila the node we are at, is the lca
        
        //else, if either left/right is not null, we return the not null part
        return (leftTree!=null)?leftTree:rightTree;
            
    }
}
