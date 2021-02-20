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
    public int maxAncestorDiff(TreeNode root) {
    DFS(root);
    return max;
    }
    public int DFS(TreeNode root){
        int min=Math.min(DFS(root.left),DFS(root.right));
        max=Math.max(max,min);
        return min
    }

}