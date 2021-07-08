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
    public boolean isSymmetric(TreeNode root) {
        return Symmetric(root,root);
    }
    public boolean Symmetric(TreeNode root1,TreeNode root2) {
        if(root1==null){
            return root2==null?true:false;
        }
        if(root2==null){
            return root1==null?true:false;
        }
        return root1.val==root2.val&&Symmetric(root1.left,root2.right)&&Symmetric(root1.right,root2.left);
    }
}