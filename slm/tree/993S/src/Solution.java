import java.util.HashMap;
import java.util.HashSet;

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
    HashMap<Integer,Integer> depth=new HashMap<>();
    HashMap<Integer,TreeNode> parent=new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
    DFS(root,x,0);
    DFS(root,y,0);
    if(depth.get(x)==depth.get(y)&&parent.get(x)!=parent.get(y)){
        return true;
    }else{
        return false;
    }
    }
    public void DFS(TreeNode root, int x,int de){
        if(root==null) return;
        if(root.val==x){
            depth.put(x,de);
        }
        if(root.right!=null){
            parent.put(root.right.val,root);
            DFS(root.right,x,de+1);
        }
        if(root.left!=null){
            parent.put(root.left.val,root);
            DFS(root.left,x,de+1);
        }
    }
}