import java.util.ArrayList;
import java.util.List;



class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode Create(){
        return   new TreeNode(3);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        DFS(root,res,0);
        res.remove(res.size()-1);
        return res;
    }
    public void DFS(TreeNode node, List<List<Integer>> res,int n){
        while(res.size()<=n){
            List<Integer> temp=new ArrayList<>();
            res.add(temp);
        }
        if(node!=null) {
            if(n%2==0){
                res.get(n).add(node.val);
            }else{
                res.get(n).add(0,node.val);
            }
            DFS(node.left, res, n + 1);
            DFS(node.right, res, n + 1);
        }
    }
}