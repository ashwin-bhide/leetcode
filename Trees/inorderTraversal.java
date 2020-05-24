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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        Stack<TreeNode> s = new Stack();
        
        //go all the way to the left
        while(root!=null){
            s.push(root);
            root = root.left;
        }
        while(!s.isEmpty()){
            TreeNode curr = s.pop();
            result.add(curr.val);
            curr = curr.right;
            while(curr!=null){
                s.push(curr);
                curr = curr.left;
            }
        }
        return result;
    }
}
