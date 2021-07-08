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
    int res=0;
    public int findTilt(TreeNode root) {
    DFS(root);
    return res;
    }
    public int DFS(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=DFS(root.left);
        int right=DFS(root.right);
        res+=Math.abs(left-right);
        return left+right+root.val;
    }
}