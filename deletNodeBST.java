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
    public int successor(TreeNode curr){
        curr=curr.right;
        while(curr.left!=null)
            curr=curr.left;
        return curr.val;
    }
    public int predecessor(TreeNode curr){
        curr=curr.left;
        while(curr.right!=null)
            curr=curr.right;
        return curr.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(key<root.val)
            root.left=deleteNode(root.left,key);
        else if(key>root.val)
            root.right=deleteNode(root.right,key);
        else{
            //no child
            if(root.left==null && root.right==null)
                root=null;
            //has right child, replace value with successor node value, recursively delete node with which you replaced
            else if(root.right!=null){
                root.val = successor(root);
                root.right = deleteNode(root.right,root.val);
            } 
            //doesn't have right child, replace with predecessor
            else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left,root.val);
            }
        }
        
        return root;
    }
}
