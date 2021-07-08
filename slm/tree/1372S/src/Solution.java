import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
    Queue<TreeNode[]> q=new LinkedList<>();
    Map<TreeNode,Integer> right=new HashMap<>();
    Map<TreeNode,Integer> left= new HashMap<>();
    public int longestZigZag(TreeNode root) {
        BFS(root);
        int max=0;
        for(TreeNode x:right.keySet()){
            max=Math.max(max,Math.max(right.get(x),left.get(x)));
        }
        return  max;
    }
    public void BFS(TreeNode root){
        right.put(root,0);
        left.put(root,0);
        q.offer(new TreeNode[]{root,null});
        while (!q.isEmpty()){
            TreeNode[] temp=q.poll();
            TreeNode x=temp[0];//子节点
            TreeNode y=temp[1];//父节点
            right.put(x,0);
            left.put(x,0);
            if(y!=null){
                if(y.left==x){//当前是左子树
                    right.put(x,left.get(y)+1);
                }
                if(y.right==x){
                    left.put(x,right.get(y)+1);
                }
            }
            if(x.left!=null){
                q.offer(new TreeNode[]{x.left,x});
            }
            if(x.right!=null){
                q.offer(new TreeNode[]{x.right,x});
            }

        }

    }
}