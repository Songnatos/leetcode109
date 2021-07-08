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
    TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    DFS(cloned,target);
    return res;
    }
    public void DFS( final TreeNode cloned, final TreeNode target){
        if(cloned==null){
            return;
        }
        else if (cloned.val==target.val){
            res=cloned;
        }else{
            DFS(cloned.left,target);
            DFS(cloned.right,target);
        }

    }
}