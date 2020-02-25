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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<>();
        
        if(root==null)
            return result;
        
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            result.add(node.val);
            if(node.right!=null)
                s.push(node.right);
            if(node.left!=null)
                s.push(node.left);
        }
        
        return result;
    }
}
