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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> s = new Stack<>();
        double inOrder = -Double.MAX_VALUE; //Double.MIN_VALUE is non-negative, so to get least number we multiple MAX_VALUE by -1
        //Inorder traversal using DFS(stacks) is best choice for BST problems
        while(!s.isEmpty() || root!=null){//second condition is added to ensure that in first step, root is added to the stack
            while(root!=null){
                s.push(root);
                root=root.left;
            }
        //Here, we compare with only one value(inorder) as all other numbers will be smaller than this due to ascending nature of inorder BST traversal
            root = s.pop();
            if(root.val<=inOrder)
                return false;
        
            inOrder = root.val;
            root=root.right;

            
        }
        return true;
    }
}
