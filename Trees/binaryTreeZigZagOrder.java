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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null)
            return result;
        
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        
        boolean isNormalOrder = true;
        while(!q.isEmpty()){
            int qsize = q.size();
            List<Integer> r = new ArrayList();
            for(int i=0;i<qsize;i++){
                TreeNode curr = q.poll();
                r.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(isNormalOrder){
                result.add(r);
                isNormalOrder = false;
            } else{
                Collections.reverse(r);
                result.add(r);
                isNormalOrder = true;
            }
            
        }
        return result;
    }
}
