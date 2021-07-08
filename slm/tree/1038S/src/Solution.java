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
    public TreeNode bstToGst(TreeNode root) {
    DFS(root);
    return root;
    }
    public void DFS(TreeNode root){
    if(root==null) return ;
    DFS(root.right);
    res+=root.val;
    root.val=res;
    DFS(root.left);
    }

}