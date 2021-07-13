class Solution {
    public boolean isBalanced(TreeNode root) {
        return root == null || Math.abs(deep(root.left) - deep(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int deep(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(deep(root.left), deep(root.right));
    }
}
