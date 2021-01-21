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
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        Qualfied(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return res;

    }

    public void  Qualfied(TreeNode root, int sum){//从当前节点有多少个可能 cnum 一直不变
        if(root==null){
            return ;
        }
        if(sum==root.val){
           res++;
        }

        Qualfied(root.left,sum-root.val);
    Qualfied(root.right,sum-root.val);
    }
}
