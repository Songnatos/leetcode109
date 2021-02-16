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
    Map<Integer,TreeNode> ans=new HashMap<>();
    List<Integer> visited=new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    DFS(root);
    while(p!=null){
        visited.add(p.val);
        p=ans.get(p.val);
    }
    while(q!=null){
        if(visited.contains(q.val)){
            return q;
        }
        visited.add(q.val);
        q=ans.get(q.val);
    }
    return root;
    }
    public  void DFS(TreeNode root){
        if(root==null){
            return;
        }
        else{
            if(root.right!=null){
                ans.put(root.right.val,root);
            }
            if(root.left!=null){
                ans.put(root.left.val,root);
            }
        }
    }
}