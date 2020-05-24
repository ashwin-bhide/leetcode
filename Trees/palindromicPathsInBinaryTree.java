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
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        findPathToLeaf(root,count);
        return result;
         
    }
    private void findPathToLeaf(TreeNode r,int[] count){
        //base condition
        if(r==null)
            return;
        //choose
        count[r.val]++;
        if(r.left==null && r.right==null){
            if(checkIfPalin(count))
                result++;
        }
        //explore
        findPathToLeaf(r.left,count);
        findPathToLeaf(r.right,count);
        
        //unchoose
        count[r.val]--;
            
    }
    
    private boolean checkIfPalin(int[] count){
        int odd = 0;
        for(int i=0;i<count.length;i++){
            if(count[i]%2!=0)
                odd++;
        }
        return (odd>1)?false:true;
    }
}
