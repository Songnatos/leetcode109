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
      Pair pair=DFS(root,distance);
      return pair.counts;
    }
    public Pair DFS(TreeNode root, int distance){
        int[] height=new int[distance+1];//叶子节点和root距离
        boolean isLeaf=(root.right==null&&root.left==null);
        if(isLeaf){
            height[0]=1;
            return new Pair(height,0);
        }
        int[] rightHeight=new int[distance+1];
        int[] leftHeight=new int[distance+1];
        int rightCount=0;int leftCount=0;
        if(root.left!=null){//获得左子树
             Pair PairLeft=DFS(root.left,distance);
            leftHeight=PairLeft.height;
            leftCount=PairLeft.counts;
        }
        if(root.right!=null){//获得右子树
            Pair right=DFS(root.right,distance);
            rightHeight=right.height;
            rightCount=right.counts;
        }
        for(int i=0;i<distance;i++){
            height[i+1]+=leftHeight[i];
            height[i+1]+=rightHeight[i];
        }
        int cn=0;
        for(int i=0;i<distance+1;i++){
            for(int j=0;i+j+2<=distance;j++){
                cn+=leftHeight[i]*rightHeight[j];
            }
        }
        return new Pair(height,cn+leftCount+rightCount);
    }
    public class Pair{
        int[] height;
        int counts;
        public Pair(int[] height,int counts){
            this.height=height;
            this.counts=counts;
        }
    }


}
