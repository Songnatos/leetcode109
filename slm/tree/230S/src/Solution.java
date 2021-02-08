import java.util.ArrayList;
import java.util.Collections;
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
    }
    List<Integer> res;
    public int kthSmallest(TreeNode root, int k) {
    res=new ArrayList<>();
    DFS(root);
        Collections.sort(res);
    return res.get(k-1);
    }
    public void DFS(TreeNode root){
        if(root==null){
            return;
        }
        res.add(root.val);
        DFS(root.left);
        DFS(root.right);
    }
}