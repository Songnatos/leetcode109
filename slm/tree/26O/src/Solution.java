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
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        return (A != null && B != null)&&(isSubStructure(A.left,B)||isSubStructure(A.right,B)||recur(A,B));
    }
    public boolean recur(TreeNode A, TreeNode B){
        if(B==null)return true;
        if(A==null||A.val!=B.val)return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}