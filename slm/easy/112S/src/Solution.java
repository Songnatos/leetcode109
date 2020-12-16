/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     public class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null||sum<0){
            return false;
        }else if(root.val==sum&&root.left==null&&root.right==null){
            return true;
        }
        else{
            return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        }
    }
}