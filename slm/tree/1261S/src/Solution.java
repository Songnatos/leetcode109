/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class FindElements {
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
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root.val=0;
        this.root=Create(root);
    }

    public boolean find(int target) {

        return findNode(target,this.root);

    }
    public boolean findNode(int target,TreeNode root) {
        if(root==null){
            return false;
        }
        if(root.val==target){
            return true;
        }
        return findNode(target,root.left)||findNode(target,root.right);

    }
    public  TreeNode Create(TreeNode root){
        int x=root.val;
        if(root==null){
            return null;
        }
        if(root.left!=null){
            root.left.val=2*x+1;
            Create(root.left);
        }
        if(root.right!=null){
            root.right.val=2*x+2;
            Create(root.right);
        }
        return  root;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */