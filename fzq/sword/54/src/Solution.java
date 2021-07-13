import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        dfs(root);
        return list.get(list.size()-k);
    }

    private void dfs(TreeNode root ) {
        if (root == null)
            return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
