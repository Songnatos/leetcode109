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
    int ans;
    public int distributeCoins(TreeNode root) {
        return DFS(root);
    }
    public  int DFS(TreeNode root){
        if(root==null){
            return 0;
        }
        int L=DFS(root.left);
        int R=DFS(root.right);
        ans+=Math.abs(L)+Math.abs(R);
        return root.val-1+L+R;
    }

}