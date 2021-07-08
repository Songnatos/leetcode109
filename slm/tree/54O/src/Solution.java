import java.util.*;

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
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int kthLargest(TreeNode root, int k) {
       List<Integer> res = new ArrayList<>();
        DFS(root,res);
        Collections.sort(res);
        Collections.reverse(res);
        return res.get(k-1);

    }
    public void DFS(TreeNode root, List<Integer> res){
        if(root==null){return;}
        else{
            res.add(root.val);
            DFS(root.right,res);
            DFS(root.left,res);
        }
    }
}