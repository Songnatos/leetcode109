/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res=new ArrayList<>();
            Queue<Node> queue=new LinkedList<>();
            queue.offer(root);
            queue.offer(null);
            List<Integer> arr=new ArrayList<>();
            while(queue.size()>1){
                Node temp=queue.poll();
                if(temp==null){
                    res.add(arr);
                    arr=new ArrayList<>();
                    queue.offer(null);
                }else{
                    arr.add(temp.val);
                    for(Node node:temp.children){
                        queue.offer(node);
                    }
                }
            }
            return  res;
        }

    }
}