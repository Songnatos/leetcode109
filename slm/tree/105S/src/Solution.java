import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

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
    HashMap<Integer,Integer> hash;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        hash=new HashMap<>();
      for(int i=0;i<inorder.length;i++){
          hash.put(inorder[i],i);
      }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if (preorder_left > preorder_right) {
            return null;
        }
        int preorder_root=preorder_left;//前序第一个值index
        int inorderroot=hash.get(preorder[preorder_root]);//定位中序index
        TreeNode  root=new TreeNode(preorder[preorder_root]);
        int left_tree=inorderroot-inorder_left;
        root.left=myBuildTree(preorder,inorder,preorder_left+1,preorder_left+left_tree,inorder_left,inorderroot-1);
        root.right=myBuildTree(preorder,inorder,preorder_left+left_tree+1,preorder_right,inorderroot+1,inorder_right);
        return root;

    }


}