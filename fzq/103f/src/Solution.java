import java.util.*;

class Solution {
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> res = new LinkedList<>();
//        if (root == null)
//            return res;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        boolean left = true;
//
//        while (!queue.isEmpty()) {
//            Deque<Integer> deque = new LinkedList<>();
//            int curSize = queue.size();
//            for (int i = 0; i < curSize; i++) {
//                TreeNode node = queue.poll();
//                if (left) {
//                    deque.offerLast(node.val);
//                } else {
//                    deque.offerFirst(node.val);
//                }
//                if (node.left != null) {
//                    queue.offer(node.left);
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                }
//            }
//            left = !left;
//            res.add(new LinkedList<>(deque));
//        }
//        return res;
//    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        boolean left = true; // true 从左
        queue.offer(root);
        while (!queue.isEmpty()) {
            left = !left;
            int i = queue.size();
            List<Integer> ans = new ArrayList<>();
            while (i-- > 0) {
                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                queue.offer(node.left);
                queue.offer(node.right);
                ans.add(node.val);
            }
            if (ans.size() != 0) {
                if (left) {
                    List<Integer> tmp = new ArrayList<>();
                    for (i = ans.size()-1; i >= 0; i--) {
                        tmp.add(ans.get(i));
                    }
                    ans = tmp;
                }
                res.add(ans);
            }
        }
        return res;
    }
}
