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
    //class variables to reduce the number of parameters passed in helper function
    int[] inorder;
    int[] postorder;
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //<postorder[index],index>
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //if length of input arrays does not match, not possible to build tree
        if(inorder==null || postorder==null || inorder.length!=postorder.length)
            return null;
        //instantiate class variables
        this.inorder = inorder;
        this.postorder = postorder;
        //create map for postorder array
        for(int i=0;i<inorder.length;++i)
            map.put(inorder[i],i);
        int n = inorder.length;
        //initially, we pass the entire arrays, so start index = 0 and end index = n-1
        return helper(0,n-1,0,n-1);
    }
    public TreeNode helper(int pstart,int pend,int istart,int iend){
        //indicates that array is empty; no need to check for istart and iend, as array length is same
        if(pstart>pend)
            return null;
        
        int rootVal = postorder[pend];   //rootvalue is last element of postorder array
        int rootIndex = map.get(rootVal); //get correspondening index of root value from inorder array; this is how the array splits into left and right subtree
        TreeNode root = new TreeNode(rootVal); 
        //Here we'll be calling helper function recursively for left subtree and right subtree
        //below we identify the start and end index values(for both inorder & postorder arrays) and for both these subtrees
        int rpend = pend-1;
        int ristart = rootIndex+1;
        int riend = iend;
        int lpstart = pstart;
        int listart = istart;
        int liend = rootIndex-1;
        int lpend = lpstart+liend-listart;
        int rpstart = lpend+1;

        root.left = helper(lpstart,lpend,listart,liend);
        root.right = helper(rpstart,rpend,ristart,riend);
        
        return root;
    }
}
