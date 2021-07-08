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
    public TreeNode pruneTree(TreeNode root) {
        judge(root);
        return root;
    }

    public boolean judge(TreeNode root){
        if(root==null)return false;
        boolean left=judge(root.left);
        boolean right=judge(root.right);
       if(!judge(root.left)) root.left=null;
        if(!judge(root.right)) root.right=null;
        return left||right||root.val==1;

    }
}