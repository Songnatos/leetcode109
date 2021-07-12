import java.util.Stack;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode newNode = new TreeNode(preorder[i]);
            TreeNode tempNode = stack.peek();
            if (inorder[index] == tempNode.val) {
                while (!stack.isEmpty() && inorder[index] == stack.peek().val) {
                    tempNode = stack.pop();
                    index++;
                }
                tempNode.right = newNode;
                stack.push(newNode);
            } else {
                tempNode.left = newNode;
                stack.push(newNode);
            }
        }
        return root;
    }
}
