import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        res.add(new ArrayList<>());
        queue.offer(root);
        queue.offer(null);
        int num=0;
        while (queue.size()>1){
            List<Integer> templist=new ArrayList<>();
            TreeNode temp=((LinkedList<TreeNode>) queue).pop();
            if (temp==null){
                res.add(new ArrayList<>());
                num++;
                queue.offer(null);
            }else{
                res.get(num).add(temp.val);
                if(temp.left!=null)
                queue.offer(temp.left);
                if(temp.right!=null)
                    queue.offer(temp.right);
            }
        }
        return res;

    }
}