import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
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
    public int getMinimumDifference(TreeNode root) {
    DFS(root);
    Collections.sort(res);
    int i=1;
    int min= Integer.MAX_VALUE;
    while(i<res.size()){
        min=Math.min(min,res.get(i)-res.get(i-1));
        i++;
    }
    return min;

    }
    public void DFS(TreeNode root){
        if(root==null)return;
        res.add(root.val);
        DFS(root.right);
        DFS(root.left);
    }
}