import java.util.ArrayList;
import java.util.List;

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
    class BSTIterator {
        private int i;
        private List<Integer> nums;

        public BSTIterator(TreeNode root) {
            nums=new ArrayList<>();
            i=0;
            DFS(root);
        }
        public void DFS(TreeNode root){
            if(root==null){
                return;
            }
            DFS(root.left);
            nums.add(root.val);
            DFS(root.right);
        }

        public int next() {
            return nums.get(i++);
        }

        public boolean hasNext() {
            return i<nums.size();
        }
    }
}