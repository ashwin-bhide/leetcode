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
        if(root==null) 
            return null;
        
        if(root==p || root==q) // this is the searching code
            return root;
        
        //below 2 lines represent inorder traversal
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left!=null && right!=null) // if both left and right are not null, then root is the LCA, pass it on to its ancestor
            return root;
        else
            return left!=null?left:right; //if one is null and other is not, pass non-null value back to its ancestor
    }
}
