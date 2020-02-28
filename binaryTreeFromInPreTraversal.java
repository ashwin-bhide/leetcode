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
    int[] preorder;
    int[] inorder;
    HashMap<Integer,Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length!=inorder.length)
            return null;
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i=0;i<inorder.length;++i)
            map.put(inorder[i],i);
        int size = inorder.length;
        return helper(0,size-1,0,size-1);
        
    }
    public TreeNode helper(int pstart,int pend,int istart,int iend){
        if(pstart>pend)
            return null;
        
        int rootVal = preorder[pstart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = map.get(root.val);
        
        int lpstart = pstart+1;
        int lpend = pstart+rootIndex-istart;
        int listart = istart;
        int liend = rootIndex-1;
        int rpstart = lpend+1;
        int rpend = pend;
        int ristart = rootIndex+1;
        int riend = iend;
        root.left = helper(lpstart,lpend,listart,liend);
        root.right = helper(rpstart,rpend,ristart,riend);
        return root;
    }
}
