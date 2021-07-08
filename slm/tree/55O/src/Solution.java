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
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return (Math.abs(height(root.left)- height(root.right))<=1)&&isBalanced(root.left)&&isBalanced((root.right));
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
}