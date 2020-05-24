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
    int[] pre;
    int[] in;
    Map<Integer,Integer> hm;
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if(n==0)
            return null;
        
        this.pre = preorder.clone();
        Arrays.sort(preorder);
        this.in = preorder.clone();
        
        hm = new HashMap();
        for(int i=0;i<n;i++)
            hm.put(in[i],i);
        
        return createTree(0,n-1,0,n-1);
    }
    private TreeNode createTree(int preStart,int preEnd,int inStart,int inEnd){
        //base condition
        if(preStart>preEnd)
            return null;
        
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        
        int rootIndex = hm.get(rootVal);
        
        //left tree
        int lps = preStart+1;
        int lis = inStart;
        int lie = rootIndex-1;
        int lpe = lps+lie-lis;
        //right tree
        int rps = lpe+1;
        int rpe = preEnd;
        int ris = rootIndex+1;
        int rie = inEnd;
        
        root.left = createTree(lps,lpe,lis,lie);
        root.right = createTree(rps,rpe,ris,rie);
        
        return root;
    }
}
