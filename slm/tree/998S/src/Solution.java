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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null||root.val<val){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        TreeNode right=insertIntoMaxTree(root.right,val);
        root.right=right;
        return root;
    }
}