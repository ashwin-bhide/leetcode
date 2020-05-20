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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        LinkedList<TreeNode> q = new LinkedList();
        
        if(root==null)
            return result;
        
        q.offer(root);
        while(!q.isEmpty()){
            int qsize = q.size();
            List<Integer> ir = new ArrayList();
            for(int i=0;i<qsize;i++){
                TreeNode curr = q.poll();
                ir.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            result.add(ir);
        }
        return result;
    }
}
