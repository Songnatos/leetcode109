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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        Queue<TreeNode> res=new LinkedList<>();
        res.offer(root);
        res.offer(null);
        int num=0;
        double count=0;
        while(res.size()>1){
            TreeNode temp=res.poll();
            if(temp==null){
                ans.add(count/num);
                res.offer(null);
                count=0;
                num=0;
            }else{
                count+=temp.val;
                num++;
                if(temp.right!=null)res.offer(temp.right);
                if(temp.left!=null)res.offer(temp.left);
            }
        }

        return ans;

    }
}