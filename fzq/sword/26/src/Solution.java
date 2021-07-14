class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        boolean res = false;
        if (A.val == B.val) {
            res = isSub(A, B);
        }
        return res || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSub(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        if (a == null || a.val != b.val)
            return false;
        return isSub(a.left, b.left) && isSub(a.right, b.right);
    }

}
