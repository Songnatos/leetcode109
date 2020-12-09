

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
    public int sumNumbers(TreeNode root) {
        int res=0;
        return goThrow(root,res,0);
    }
    public int  goThrow(TreeNode node, int res, int temp){
        if(node==null){return 0;}
        else if(node.left==null&&node.right==null){
            return res+=temp*10+node.val;
        }else{
        return  goThrow(node.left,res,temp*10+node.val)+goThrow(node.right,res,temp*10+node.val);
    }
    }
}