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
    public int sumOfLeftLeaves(TreeNode root) {
    DFS(root,0);
    return res;
    }
    public void DFS(TreeNode root,int num){
        if(root==null){
            return;
        }
        boolean isleaf=root.left==null&&root.right==null;
        if(num==1&&isleaf){
            res+=root.val;
        }
        DFS(root.right,0);
        DFS(root.left,1);
    }

}