import sun.reflect.generics.tree.Tree;

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
    public List<Integer> preorderTraversal(TreeNode root) {
    DFS(root);
    return res;
    }
    public void DFS(TreeNode root){
        if (root == null) {
        return;
        }
        res.add(root.val);
        DFS(root.left);
        DFS(root.right);
        }
    }
