import java.util.HashMap;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    HashMap<Integer,Integer> inmap=new HashMap<>();
    int[] pre;
    int[] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    pre=preorder;
    in=inorder;
    int n=inorder.length;
    for(int i=0;i<n;i++){
        inmap.put(inorder[i],i);
    }
    return create(0,n-1,0,n-1);
    }
    public TreeNode create(int ps,int pe,int is,int ie){
        if(ps>pe||is>ie){
            return  null;
        }
        int index=inmap.get(pre[ps]);
        TreeNode root=new TreeNode(pre[ps]);
        int length=index-is;
        root.left=create(ps+1,ps+length,is,index-1);
        root.right=create(ps+length+1,pe,index+1,ie);
        return root;
    }
}