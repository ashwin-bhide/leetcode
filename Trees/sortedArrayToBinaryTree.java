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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;
        //recursively pick middle element as root, 0..mid-1 as left tree and mid+1 to n as right tree
        int start = 0, end = nums.length-1;
        return createTree(start,end,nums);
    }
    private TreeNode createTree(int start,int end, int[] nums){
        //base condition
        if(start>end)
            return null;
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(start,mid-1,nums);
        root.right = createTree(mid+1,end,nums);
        
        return root;
    }
}
