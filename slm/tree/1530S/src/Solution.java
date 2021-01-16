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

    int max;
    public int countPairs(TreeNode root, int distance) {
        max=distance;
        int[] resright=new int[distance];
        int[] resleft=new int[distance];
        int res=0;
        for(int i=0;i<distance;i++){
            resright[i]=0;resleft[i]=0;
        }
        height(root.right,1,resright);
        height(root.left,1,resleft);
        for(int i=1;i<distance;i++){
            res+=resleft[i]+resright[distance-i];
        }
        return res;
    }
    public  void height(TreeNode root, int height,int[] res){
        if(height>=max||root==null)return;
        if(root.left==null&&root.right==null){
            res[height]++;
        }else{
            height(root.left,height+1,res);
            height(root.right,height+1,res);
        }
    }


}
