import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<Integer,TreeNode> map=new HashMap<>();
    List<TreeNode> res=new ArrayList<>();
    public void DFS(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            map.put(root.left.val,root);
        }
        if(root.right!=null){
            map.put(root.right.val,root);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    DFS(root);
    while(p!=null){
        res.add(p);
        p=map.get(p.val);
    }
    while(q!=null){
            if(res.contains(q)){
                return q;
            }
            q=map.get(q.val);
        }
    return root;
    }
}