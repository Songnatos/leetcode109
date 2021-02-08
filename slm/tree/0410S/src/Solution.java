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
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(t1);
        queue.offer(null);
        while(queue.size()>1){
            TreeNode temp=queue.poll();
            if(temp==null){
                queue.offer(null);
            }else{
                if(temp.val==t2.val&&check(temp,t2)){
                    return true;
                }
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
            }
        }
        return false;
    }
    public boolean check(TreeNode t1, TreeNode t2) {
        if(t1==null&&t2==null){
            return true;
        }
        if(t1==null&&t2!=null||t2==null&&t1!=null){
            return false;
        }
    if(t1.val==t2.val){
        return check(t1.right,t2.right)&&check(t1.left,t2.left);
    }else{
        return false;
    }
    }
}