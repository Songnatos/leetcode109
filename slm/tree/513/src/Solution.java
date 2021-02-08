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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int res=root.val;
        while(queue.size()>1){
            TreeNode temp=queue.poll();
            if(temp==null){
                queue.offer(null);
                TreeNode temp2=queue.poll();
                if(temp2!=null){
                    res=temp2.val;
                    if(temp2.left!=null)queue.offer(temp2.left);
                    if(temp2.right!=null)queue.offer(temp2.right);

                }
            }else{
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);

            }
        }
        return res;
    }
}