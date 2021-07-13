class Solution {
    /**
     * 搜索树的条件忘记用了
     */
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (isParent(root, p) && isParent(root, q)) {
//            if (lowestCommonAncestor(root.left, p, q) != null) {
//                root = root.left;
//            }
//            if (lowestCommonAncestor(root.right, p, q) != null) {
//                root = root.right;
//            }
//        } else {
//            return null;
//        }
//        return root;
//    }
//
//    private boolean isParent(TreeNode parent, TreeNode child) {
//        if (parent == null || child == null)
//            return false;
//        if (parent == child || parent.left == child || parent.right == child)
//            return true;
//
//        return isParent(parent.left, child) || isParent(parent.right, child);
//    }
}
