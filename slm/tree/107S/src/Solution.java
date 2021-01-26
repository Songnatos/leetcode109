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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        res.add(new ArrayList<>());
        int height=0;
        while (queue.size()>1){
            TreeNode temp=queue.poll();
            List<Integer> list =new ArrayList<>();
            if(temp==null){
                res.add(new ArrayList<>());
                height++;
                queue.offer(null);
            }else{
                res.get(height).add(temp.val);
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
        }
        Collections.reverse(res);
        return res;

    }
}