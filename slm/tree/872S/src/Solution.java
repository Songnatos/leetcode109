import org.omg.CORBA.INTERNAL;

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
    List<Integer> res1=new ArrayList<>();
    List<Integer> res2=new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    DFS(root1,res1);
    DFS(root2,res2);
    if(res1.size()!=res2.size()){
        return false;
    }
    int i=0;
    while(i<res1.size()){
        if(res1.get(i)!=res2.get(i)){
            return false;
        }
        i++;
    }
    return true;
    }
    public void DFS(TreeNode root,List<Integer> res){
        if(root==null)return;
        DFS(root.left,res);
        DFS(root.right,res);
        boolean isleaf=root.right==null&&root.left==null;
        if(isleaf){
            res.add(root.val);
        }
    }
}