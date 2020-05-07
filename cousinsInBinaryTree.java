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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        
        Queue<TreeNode> q = new LinkedList();
        if(root.left==null || root.right==null) //ensures both are not null
            return false;
        q.offer(root.left); //we start level 1
        q.offer(root.right);
        
        while(!q.isEmpty()){
            boolean xFound = false;
            boolean yFound = false;
            int qsize = q.size();
            for(int i=0;i<qsize;i++){
                TreeNode curr = q.poll();
                TreeNode currLC = curr.left;
                TreeNode currRC = curr.right;
                if(currLC!=null && currRC!=null){
                    if((currLC.val==x || currRC.val==x) && (currLC.val==y || currRC.val==y))
                        return false;
                }
                if(currLC!=null) q.offer(currLC);
                if(currRC!=null) q.offer(currRC);
                if((currLC!=null && currLC.val==x) || (currRC!=null && currRC.val==x))
                    xFound = true;
                if((currLC!=null && currLC.val==y) || (currRC!=null && currRC.val==y))
                    yFound = true;
            }
            if(xFound && yFound)
                return true;
        }
        return false;
    }
}
