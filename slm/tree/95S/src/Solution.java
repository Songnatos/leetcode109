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

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
    return create(1,n);
    }
    public List<TreeNode> create(int start,int end){
        List<TreeNode> res=new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=create(start,i-1);
            List<TreeNode> right=create(i+1,end);
            for(TreeNode lef:left){
                for(TreeNode rig:right){
                    TreeNode temp=new TreeNode(i);
                    temp.left=lef;
                    temp.right=rig;
                    res.add(temp);
                }
            }

        }
        return res;

    }
}