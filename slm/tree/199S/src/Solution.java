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
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);
        boolean flag=false;//判断这一层有没有拿取值
        while(queue.size()>1){
            TreeNode temp=queue.poll();
        if(temp==null){
            flag=false;
            queue.offer(null);
        }else{
            if(temp.right!=null) queue.offer(temp.right);
            if(temp.left!=null) queue.offer(temp.left);
            if(!flag){
                flag=true;
                res.add(temp.val);
            }
        }
        }
        return res;
    }
}