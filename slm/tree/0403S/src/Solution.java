/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode[] listOfDepth(TreeNode tree) {
        int n=height(tree);
        ListNode[] res=new ListNode[n];
        BFS(tree,res,n,n);
        return res;
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }else{
            return Math.max(height(root.left),height(root.right))+1;
        }
    }
    public void BFS(TreeNode tree,ListNode[] res,int height,int heightnow){
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(tree);
        queue.offer(null);
        while(queue.size()>1){
            TreeNode temp=((LinkedList<TreeNode>) queue).pop();
            if(temp==null){
                heightnow--;
                queue.offer(null);
            }else if (res[height-heightnow]==null){
                res[height-heightnow]=new ListNode(temp.val);
                if(temp.left!=null)
                queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
            }
            else{
                ListNode temp1= res[height-heightnow];
                while(temp1.next!=null){
                    temp1=temp1.next;
                }
                temp1.next=new ListNode(temp.val);
                if(temp.left!=null)
                    queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
        }
        }
    }

}