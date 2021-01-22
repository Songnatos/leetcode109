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
    public void flatten(TreeNode root) {
    DFS(root);
     boolean flag=false;
        root.left=null;
    for(Integer temp:res){
        if(flag){
            root.right=new TreeNode(temp);
            root=root.right;
        }else{
           flag=true;
       }
    }
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