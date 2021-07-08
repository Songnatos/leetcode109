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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res=new ArrayList<>();
        create(N,res);
        return res;
    }
    public void  create(int n,List<TreeNode> res){
        if(n==1){
             res.add(new TreeNode(0));
             return ;
        }
        for(int i=1;i<n-1;i=i+2){
            List<TreeNode> l=new ArrayList<>();
            List<TreeNode> r=new ArrayList<>();
            create(i,l);
            create(n-i-1,r);
            for(TreeNode left:l){
                for(TreeNode right:r){
                    TreeNode m=new TreeNode(0);
                    m.left=left;
                    m.right=right;
                    res.add(m);
                }
            }
        }

    }
}