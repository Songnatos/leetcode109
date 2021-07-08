import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res=new ArrayList<TreeNode>();
        boolean flag=true;
        for(int num:to_delete){
            if(num==root.val){
                flag=false;
            }
        }
        if(flag){
            res.add(root);
        }else{
            if(root.left!=null){
                res.add(root.left);
            }
            if(root.right!=null){
                res.add(root.right);
            }
        }
        DFS(root,to_delete,res);
        return res;

    }
    public void DFS(TreeNode root,int[] to_delete, List<TreeNode> res){
        if(root==null){
            return ;
        }
        boolean leftflag=false;
        boolean rightflag=false;
        for(int num:to_delete){
            if(root.left!=null&&num==root.left.val){
                leftflag=true;
            }
            if(root.right!=null&&num==root.right.val){
                rightflag=true;
            }
        }

        if(leftflag){
            if(root.left.left!=null)res.add(root.left.left);
            if(root.left.right!=null)res.add(root.left.right);
            root.left=null;
        }
        if(rightflag){
            if(root.right.left!=null)res.add(root.right.left);
            if(root.right.right!=null)res.add(root.right.right);
            root.right=null;
        }
        DFS(root.left,to_delete,res);
        DFS(root.right,to_delete,res);
    }
}