import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> temp=new LinkedList<>();
        temp.offer(root);
        temp.offer(null);
        List<Integer> res=new ArrayList<>();
        int count=0;
        while(temp.size()>1){
            TreeNode node=temp.poll();
            if(node==null){
                temp.offer(null);
                res.add(count);
                count=0;
            }else{
                count+=node.val;
                if(node.right!=null){temp.offer(node.right);}
                if(node.right!=null){temp.offer(node.right);}
            }
        }
        return res.get(res.size()-1);
    }
}