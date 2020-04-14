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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null)
            return result;
        
        LinkedList<TreeNode> dq = new LinkedList<TreeNode>();
    
        boolean isLtoR = true; //indicates how to order intermediate result
        dq.add(root);
        
        while(!dq.isEmpty()){
            int size = dq.size();
            LinkedList<Integer> ir = new LinkedList();
            for(int i=0;i<size;i++){
                TreeNode t = dq.poll();
                if(isLtoR)
                    ir.addLast(t.val);
                else
                    ir.addFirst(t.val);
                
                if(t.left!=null) dq.addLast(t.left);
                if(t.right!=null) dq.addLast(t.right);
                
            }
            result.add(ir);
            isLtoR = !isLtoR; //flip direction
        }
        return result;
    }
}
