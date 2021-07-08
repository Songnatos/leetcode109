import java.util.ArrayList;
import java.util.List;

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
    } List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
    res=new ArrayList<>();
    DFS(root);
    return res;
    }
    public void DFS(TreeNode root){
        if(root==null){
            return;
        }
        DFS(root.left);
        DFS(root.right);
        res.add(root.val);
    }
}