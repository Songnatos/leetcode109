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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        return DFS(root,root.val);

    }
    public boolean DFS(TreeNode root,int val){
        if(root==null){
            return true;
        }
        if(root.val!=val){
            return false;
        }else{
            return DFS(root.right,val)&&DFS(root.left,val);
        }
    }
}