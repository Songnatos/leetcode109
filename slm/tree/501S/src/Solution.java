import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    HashMap<Integer,Integer> res=new HashMap<>();
    public int[] findMode(TreeNode root) {
        List<Integer> temp=new ArrayList<>();
    DFS(root);
    int max= Integer.MIN_VALUE;
    for(Integer key:res.keySet()){
        max=Math.max(max,res.get(key));
    }
    for(Integer key:res.keySet()){
            if(res.get(key)==max){
                temp.add(key);
            }
        }
    int[] te=new int[temp.size()];
    for(int i=0;i<temp.size();i++){
        te[i]=temp.get(i);
    }
    return te;
    }
    public void DFS(TreeNode root){
        if(root==null){
            return;
        }
        if(res.get(root.val)==null){
            res.put(root.val,0);
        }else{
            res.put(root.val,res.get(root.val)+1);
        }
        DFS(root.right);
        DFS(root.left);
    }
}