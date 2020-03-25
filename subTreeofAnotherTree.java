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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //check if t(subtree) is null
        if(t==null)
            return true;
        //if subtree is not null and main tree is null
        if(s==null)
            return false;
        //if both trees are identical, same at root level
        if(isIdentical(s,t))
            return true;
        //if none of above condition satisfies, check if either left/right subtree matches
        return (isSubtree(s.left,t) || isSubtree(s.right,t));
    }
    public boolean isIdentical(TreeNode n1,TreeNode n2){
        //if both are null then identical
        if(n1==null && n2==null)
            return true;
        //if both are not null, investigate further
        if(n1!=null && n2!=null){
            if((n1.val==n2.val) && isIdentical(n1.left,n2.left) && isIdentical(n1.right,n2.right))
                return true;
        }
        //for all other conditions
        return false;
    }
}
