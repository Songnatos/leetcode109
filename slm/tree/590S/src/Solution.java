import java.util.ArrayList;
import java.util.List;

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
    }
    public List<Integer> postorder(Node root) {
        List<Integer> res=new ArrayList<>();
        DFS(res,root);
        return res;
    }
    public  void DFS(List<Integer> res,Node root){
        if(root==null){
            return;
        }
        for(Node child:root.children){
            DFS(res,child);
        }
        res.add(root.val);

    }
}