import java.util.LinkedList;
import java.util.Queue;

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
    public int sumEvenGrandparent(TreeNode root) {
        int count=0;
    if(root==null||(root.right==null&&root.left==null)){
        return 0;
    }
    if(root.right!=null&&root.val%2==0){
        if(root.right.right!=null)count+=root.right.right.val;
        if(root.right.left!=null)count+=root.right.left.val;
    }
    if(root.left!=null&&root.val%2==0){
            if(root.left.right!=null)count+=root.left.right.val;
            if(root.left.left!=null)count+=root.left.left.val;
        }
    return sumEvenGrandparent(root.right)+sumEvenGrandparent(root.right)+count;
    }
}