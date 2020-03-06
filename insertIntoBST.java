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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;
        while(curr!=null){
            if(val<curr.val){
                if(curr.left==null){
                    curr.left=new TreeNode(val);
                    return root;
                }
                curr=curr.left;    
            } else{
                if(curr.right==null){
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr=curr.right;
            }
        }
        return new TreeNode(val);
    }
}
