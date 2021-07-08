import java.util.LinkedList;
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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int res=1;
        while(queue.size()>1){
            TreeNode temp=queue.poll();
            if(temp==null){
                res++;
                queue.offer(null);
            }else{
                boolean isleaf=temp.left==null&&temp.right==null;
                if(isleaf)return res;
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
            }

        }
        return res;
    }
}