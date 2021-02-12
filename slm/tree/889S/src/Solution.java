import org.omg.CORBA.INTERNAL;

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
    Map<Integer, Integer> preo=new HashMap<>();
    Map<Integer, Integer> posto=new HashMap<>();
    int[] prei;
    int[] posti;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        prei=pre;
        posti=post;
    for(int i=0;i<pre.length;i++){
        preo.put(pre[i],i);
        posto.put(post[i],i);
    }
    return  create(0,pre.length-1,0,post.length-1);
    }
    public TreeNode create(int ps,int pe,int pos,int poe){
        if(ps>pe||pos>poe){
            return null;
        }
        TreeNode root=new TreeNode(posti[poe]);
        if(ps==pe&&pos==poe){
            return root;
        }
        int leftlength=preo.get(posti[poe-1])-ps-1;
        root.left=create(ps+1,ps+leftlength,pos,pos+leftlength-1);
        root.right=create(ps+1+leftlength,pe,pos+leftlength,poe-1);
        return root;
    }
}