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
    public String tree2str(TreeNode t) {
        String res=new String();
        res+=t.val;
        if(t.left!=null){
            res=res+"("+tree2str(t.left)+")";
        }
        if(t.right!=null){
            if(t.left==null){
                res=res+"()("+tree2str(t.right)+")";
            }else{
            res=res+"("+tree2str(t.right)+")";
        }}
        return res;
    }
}