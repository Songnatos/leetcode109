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
    public TreeNode bstFromPreorder(int[] preorder) {
    return create(preorder,0,preorder.length);
    }
    public TreeNode create(int[] preorder,int start,int end){
        if(start>end||start>=preorder.length){
            return  null;
        }
        TreeNode root=new TreeNode(preorder[start]);
        int i=1;
        while(preorder[start+i]<preorder[start]||start+i<preorder.length){
            i++;
        }
        root.left=create(preorder,start+1,start+i);
        root.left=create(preorder,start+i+1,end);
        return root;
    }
}