/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node>  res=new LinkedList<>();
        res.offer(root);
        res.offer(null);
        Node sb=null;
        while(res.size()>1){
            Node temp=res.poll();
            if(temp==null){
                sb.next=temp;
                sb=null;
                res.offer(null);
            }else{
                if(sb!=null)
              sb.next=temp;
              if(temp.left!=null){
                  res.offer(temp.left);
                  res.offer(temp.right);
              }

            }
            sb=temp;


        }
        return  root;

    }
}