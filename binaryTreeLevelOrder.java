/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        int level = 0;
        
        if(root==null) return result;
        
        q.add(root);
        while(!q.isEmpty()){
            result.add(new ArrayList<Integer>());
            
            int level_len = q.size();
            for(int i=0;i<level_len;++i){
                TreeNode n = q.remove();
                result.get(level).add(n.val);
                
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            level++;
        }
        return result;
        
    }
}
