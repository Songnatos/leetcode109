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
    int max=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
    height(root);
    return max;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int left=height(root.left);
            int right=height(root.right);
            max=Math.max(max,left+right+1);
            return  Math.max(height(root.left),height(root.right))+1;
        }
    }
}