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
    public boolean isSymmetric(TreeNode root){
        LinkedList<TreeNode> q = new LinkedList();
        q.offer(root);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode p1 = q.poll();
            TreeNode p2 = q.poll();
            
            if(p1==null && p2==null)
                continue;
            if(p1==null || p2==null) //if either node is null, tree is not symmetric
                return false;
            if(p1.val!=p2.val)
                return false;
            //if parent values are equal then push children in mirror order
            q.offer(p1.left);
            q.offer(p2.right);
            q.offer(p1.right);
            q.offer(p2.left);
        }
        return true;
    }
    // ****DFS Solution *****
    // public boolean isSymmetric(TreeNode root) {
    //     return isMirror(root,root);
    // }
    // private boolean isMirror(TreeNode parent1, TreeNode parent2){
    //     if(parent1==null && parent2==null) 
    //         return true;
    //     if(parent1==null || parent2==null) //if either parent is null, tree is not symmetric
    //         return false;
    //     return (parent1.val==parent2.val) 
    //         && isMirror(parent1.right,parent2.left) 
    //         && isMirror(parent1.left,parent2.right);
    // }
}
