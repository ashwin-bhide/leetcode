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
    public boolean isValidBST(TreeNode root) {
        //perform inorder traversal using stack
        //if values are not in ascending order, tree is not BST
        if(root==null)
            return true;
        
        Deque<TreeNode> stack = new ArrayDeque();
        double inorder = -Double.MAX_VALUE;
        //go all the way to the left
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.val<=inorder)
                return false;
            inorder = curr.val;
            curr = curr.right;
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }    
        }
        return true;
    }
}
