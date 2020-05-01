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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root==null || arr.length==0)
            return false;
        return isValidSequenceHelper(root,arr,0);
        
    }
    private boolean isValidSequenceHelper(TreeNode root,int[] arr,int index){
        if(root==null) //more elements left to process, but we already exhausted nodes in current path
            return false; 
        else if(index==arr.length) //index has crossed array length
            return false;
        else if(root.val!=arr[index]) //values don't match
            return false;
        else if(root.left==null && root.right==null && index==arr.length-1) //positive
            return true;
        
        return (isValidSequenceHelper(root.left,arr,index+1) || isValidSequenceHelper(root.right,arr,index+1));
        
    }
}
