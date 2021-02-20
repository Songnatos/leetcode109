import org.omg.CORBA.INTERNAL;

import java.util.*;

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
    Map<Integer,Integer> map=new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
    DFS(root);
    int max=Integer.MIN_VALUE;
        List<Integer> res=new ArrayList<>();
    for(Integer temp:map.keySet()){
        max=Math.max(max,map.get(temp));
    }
    for(Integer temp:map.keySet()){
            if(max==map.get(temp)){
                res.add(temp);
            }
        }
    int[] ress=new int[res.size()];
    for(int i=0;i<res.size();i++){
        ress[i]=res.get(i);
    }
    return ress;


    }
    public int DFS(TreeNode root){
        if(root==null){
            return 0;
        }
        int sum=root.val+DFS(root.right)+DFS(root.left);
        if(map.get(sum)==null){
            map.put(sum,0);
        }else{
            map.put(sum,map.get(sum)+1);
        }
        return sum;
    }
}