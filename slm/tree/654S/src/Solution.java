/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return DSF(nums,0,nums.length);
    }
    public TreeNode  DSF(int[]nums,int begin,int end){
        if(begin==end){
            return null;
        }
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=begin;i<end;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=DSF(nums,begin,index);
        root.right=DSF(nums,index+1,end);
        return root;
    }
}