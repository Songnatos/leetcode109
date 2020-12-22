import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left = true;

        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.poll();
                if (left) {
                    deque.offerLast(node.val);
                } else {
                    deque.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            left = !left;
            res.add(new LinkedList<>(deque));
        }
        return res;
    }
}
