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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res=new ArrayList<>();
        DFS(res,root1);
        DFS(res,root2);
        Collections.sort(res);
        return  res;
    }
    public void DFS(List<Integer> res,TreeNode root){
        if(root==null){
            return ;
        }
        res.add(root.val);
        DFS(res,root.right);
        DFS(res,root.left);
    }
}