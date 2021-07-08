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
    public TreeNode sortedArrayToBST(int[] nums) {
    return Create( nums,0,nums.length);
    }
    public TreeNode Create(int[] nums,int left,int right) {
        if(left>right){
            return null;
        }else{
            int mid=(left+right)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=Create(nums,left,mid);
            root.right=Create(nums,mid+1,right);
            return root;
        }

    }
}