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
    public TreeNode searchBST(TreeNode root, int val) {
    if(root==null){return null;}
    if(root.val==val){return root;}
        TreeNode roota=searchBST(root.right,val);
        TreeNode rootb=searchBST(root.left,val);
        if(roota!=null){
            return roota;
        }else if(rootb!=null){return rootb;}
        else{return null;}

    }
}