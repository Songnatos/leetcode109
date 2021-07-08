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
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> res=new LinkedList<>();
        int max=Integer.MIN_VALUE;
        res.offer(root);
        res.offer(null);
        int temonum=0;
        int level=1;
        int maxLevel=0;
        while(res.size()>1){
            TreeNode temp=res.poll();
            if(temp==null){
                if(temonum>max){
                    max=temonum;
                    maxLevel=level;
                }
                temonum=0;
                level++;
                res.offer(null);
            }else{
                temonum+=temp.val;
                if(temp.left!=null){
                    res.offer(temp.left);
                }
                if(temp.right!=null){
                    res.offer(temp.right);
                }
            }
        }
        return Math.max(max,temonum);
    }
}