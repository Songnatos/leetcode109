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
    public int sumRootToLeaf(TreeNode root) {
    return  DFS(root,0);
    }
    public int DFS(TreeNode root,int value){
        boolean isLeaf=(root.right==null&&root.left==null);
        if(isLeaf){
            return value*2+root.val;
        }else if(root.right==null){
            return DFS(root.left,value*2+root.val);
        }else if(root.left==null){
            return DFS(root.right,value*2+root.val);
        }else{
            return DFS(root.right,value*2+root.val)+DFS(root.left,value*2+root.val);
        }
    }
}