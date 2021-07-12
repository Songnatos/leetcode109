import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List< List<Integer> > levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        queue.add(root);
        TreeNode node;

        while (!queue.isEmpty()) {
            int i = queue.size();
            while (i-- > 0) {
                node = queue.poll();
                if (node != null) {
                    temp.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (temp.size() > 0) {
                res.add(temp);
                temp = new ArrayList<>();
            }
        }

        return res;
    }
}
