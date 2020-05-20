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
    public int kthSmallest(TreeNode root, int k) {
        //inorder traversal of BST is in ascending order
        int inorder = 0;
        Stack<TreeNode> s = new Stack();
        //go all the way to the left
        while(root!=null){
            s.push(root);
            root = root.left;
        }
        while(!s.isEmpty()){
            inorder++;
            root = s.pop();
            if(k==inorder)
                return root.val;
            root = root.right;
            while(root!=null){
                s.push(root);
                root = root.left;
            }
        }
        return -1;
    }
}
