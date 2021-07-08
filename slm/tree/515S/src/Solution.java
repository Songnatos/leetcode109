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
    }public List<Integer> largestValues(TreeNode root) {
        if(root==null)return new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int max=Integer.MIN_VALUE;
        while(queue.size()>1){
            TreeNode temp=queue.poll();
            if(temp==null){
                res.add(max);
                queue.offer(null);
                max=Integer.MIN_VALUE;
            }else{
                max=Math.max(max,temp.val);
                if(temp.left!=null){queue.offer(temp.left);}
                if(temp.right!=null){queue.offer(temp.right);}
            }
        }
        return res;

    }

}