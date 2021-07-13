class Solution {
    //fixme: 可以记录下谁是谁的祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (isParent(root, p) && isParent(root, q)) {
            TreeNode tempNode;
            if ((tempNode = lowestCommonAncestor(root.left, p, q)) != null) {
                root = tempNode;
            }
            if ((tempNode = lowestCommonAncestor(root.right, p, q)) != null) {
                root = tempNode;
            }
        } else {
            return null;
        }
        return root;
    }

    private boolean isParent(TreeNode parent, TreeNode child) {
        if (parent == null || child == null)
            return false;
        if (parent == child || parent.left == child || parent.right == child)
            return true;

        return isParent(parent.left, child) || isParent(parent.right, child);
    }
}
