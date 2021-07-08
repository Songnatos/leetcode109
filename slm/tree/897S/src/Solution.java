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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer>res =new ArrayList<>();
        DFS(root,res);
        TreeNode temproot=new TreeNode();
        TreeNode temp=temproot;
        for(Integer num:res){
            temp.right=new TreeNode(num);
            temp=temp.right;
        }
        return temproot.right;

    }
    public void DFS(TreeNode root, List<Integer> res){
        if(root==null){return;}
        else{
            DFS(root.right,res);
            res.add(root.val);
            DFS(root.left,res);
        }
    }
}