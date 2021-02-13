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
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
    if(root==null){
        return new ArrayList<>();
    }
    boolean isleaf=root.left==null&&root.right==null;
    if (isleaf){
        res.add(String.valueOf(root.val));
    }else{
        DFS(root,String.valueOf(root.val));
    }
    return res;
    }
    public void DFS(TreeNode root,String s){
        if(root==null){
            return;
        }
        boolean isleaf=root.left==null&&root.right==null;
        if(isleaf){
            res.add(s+"->"+root.val);
        }else{
            DFS(root.left,s+"->"+root.val);
            DFS(root.right,s+"->"+root.val);
        }

    }
}