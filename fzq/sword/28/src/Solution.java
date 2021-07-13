import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.left);
                    list.add(node.right);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!isSymmetricList(list))
                return false;
        }
        return true;
    }

    private boolean isSymmetricList(List<TreeNode> list) {
        for (int i = 0; i < list.size()/2; i++) {
            TreeNode a = list.get(i), b = list.get(list.size()-1-i);
            if (a == null && b == null) {
            } else if (a == null || b == null) {
                return false;
            } else {
                if (a.val != b.val) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }




















}
