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
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        boolean isleaf=root.left==null&&root.right==null;
        if(isleaf){
            return root;
        }
        TreeNode temp=mirrorTree(root.left);
        root.left=mirrorTree(root.right);
        root.right=temp;
        return root;
    }
}