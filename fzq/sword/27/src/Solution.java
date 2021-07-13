import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = left;
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null)
                continue;
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }
}
