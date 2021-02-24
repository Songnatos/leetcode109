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
    }
    List<Integer> res=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
    DFS(root);
    for(Integer temp:res){
        res.remove(temp);
        int c=k-temp;
        if(res.contains(c)){
            return true;
        }
    }
    return false;
    }
    public void DFS(TreeNode root){
        if (root==null) return;
        res.add(root.val);
        DFS(root.left);
        DFS(root.right);
    }
}