import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list = new ArrayList<>();

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        dfs(root);


        return null;
    }

    private TreeNode build(TreeNode p, int val) {
        if (p == null) {
            p = new TreeNode(val);
            return p;
        }
        p.right = build(p.right, val);
        p.left = build(p.left, val);
        return p;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
