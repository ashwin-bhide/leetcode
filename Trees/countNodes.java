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
    public int countNodes(TreeNode root) {
        int ld = leftDepth(root); //find left depth
        int rd = rightDepth(root);//find right depth
        
        if(ld == rd)
            return (int)Math.pow(2,ld) - 1; //depths are equal; perfect binary tree, #nodes = 2^depth - 1
        
        return 1+countNodes(root.left)+countNodes(root.right); //if depths are not equal
    }
    private int leftDepth(TreeNode node){
        int d = 0;
        while(node!=null){
            node = node.left;
            d++;
        }
        return d;
    }
    private int rightDepth(TreeNode node){
        int d = 0;
        while(node!=null){
            node = node.right;
            d++;
        }
        return d;
    }
    //Time compelexity: O((logN)*(logN))
}
