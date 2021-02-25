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
    public boolean isValidBST(TreeNode root) {
    DFS(root);
    int i=1;
    while(i<res.size()){
        if(res.get(i)<=res.get(i-1)){
            return false;
        }
        i++;
    }
    return true;
    }
    public void DFS(TreeNode root){
        if(root==null){
            return;
        }
        DFS(root.left);
        res.add(root.val);
        DFS(root.right);
    }
}