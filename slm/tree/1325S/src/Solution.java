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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null){
            return null;
        }
        root.right=removeLeafNodes(root.right,target);
        root.left=removeLeafNodes(root.left,target);
        boolean isleaf=root.left==null&&root.right==null;
        if(isleaf&&root.val==target){
            return null;
        }
        return root;
    }
}