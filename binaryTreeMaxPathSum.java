/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
      int max = -Integer.MAX_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        
        return max;
    }
    private int maxPathSumHelper(TreeNode root){
        if(root==null)
            return 0;
        
        //case 1: current node is in the path of maxPath, so find max of left and right tree of current
        // and add to the curr value; 
        //add sum of either of the trees to curr node value
        int leftSum = maxPathSumHelper(root.left);
        int rightSum = maxPathSumHelper(root.right);
        int rootVal = root.val;
        int sumUntilRoot = Math.max(Math.max(leftSum,rightSum)+rootVal,rootVal);
        
        //case 2: current node is the root of the maxPath
        //add sum of both trees to curr node value
        int sumAtNode = Math.max(sumUntilRoot,leftSum+rightSum+rootVal);
        
        max = Math.max(max,sumAtNode);
        
        return sumUntilRoot;
    }
}
