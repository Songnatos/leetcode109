import java.util.HashMap;
import java.util.Map;

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
    Map<Integer,Integer> numToindex=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<postorder.length;i++){
            numToindex.put(postorder[i],i);
        }
    return Create(inorder,postorder,0,inorder.length-1,0,inorder.length+1);
    }
    public TreeNode Create(int[] inorder, int[] postorder,int left,int right,int start,int end){//left right表示后续遍历开始和结束
        if(left>right||start>end){
            return null;
        }
        TreeNode root=new TreeNode(postorder[right]);
        int index=numToindex.get(postorder[right]);

        root.left=Create(inorder,postorder,left,left+index-start-1,start,index-1);
        root.right=Create(inorder,postorder,left+index-start,right-1,index+1,end);
        return root;

    }
}