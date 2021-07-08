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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(Height(root.left)==Height(root.right)){
            return root;
        }else if (Height(root.left)>Height(root.right)){
            return lcaDeepestLeaves(root.left);
        }else{
            return lcaDeepestLeaves(root.right);
        }

    }
    public int Height(TreeNode root){
        if(root==null){
            return 0;
        }else{
            return Math.max(Height(root.left),Height(root.right))+1;
        }
    }
}