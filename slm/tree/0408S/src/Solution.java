import java.util.ArrayList;
import java.util.HashMap;
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
    HashMap<Integer,TreeNode> map=new HashMap<>();
    List<Integer> vistied=new ArrayList<>();
    public void DFS(TreeNode root){
        if(root.right!=null){
            map.put(root.right.val,root);
            DFS(root.right);
        }
        if(root.left!=null){
            map.put(root.left.val,root);
            DFS(root.left);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root);
        while(p!=null){
            vistied.add(map.get(p.val));
            p=map.get(p.val);
        }
        while(q!=null){
            if(vistied.contains(q.val)){
                return q.val;
            }
            q=map.get(q.val);
        }
        return root;
    }
}