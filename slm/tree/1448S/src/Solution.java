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
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
    return count(root,root.val)+1;
    }
    public int count(TreeNode root,int max){
        if(root==null){
            return 0;
        }
        int count=0;
        if(root.val>=max){
            max=root.val;
            count++;
        }
        return count+count(root.right,max)+count(root.left,max);
    }
}