import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {

    public TreeNode buildTree(List<String> input) {
        TreeNode root = buildTreeIndex(input, 0);
        return root;
    }

    public TreeNode buildTreeIndex(List<String> input ,int index) {
        if (input.size() <= index) {
            return null;
        }
        if (input.get(index) == "null") {
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(input.get(index)));
        cur.left = buildTreeIndex(input, index * 2 + 1);
        cur.right = buildTreeIndex(input, index * 2 + 2);
        return cur;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subArray = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> temp = queue.poll();
                TreeNode cur = temp.getKey();
                Integer value = temp.getValue();
                if (cur != null) {
                    System.out.println("curTree " + cur.val + " value " + value);
//                    subArray.add(cur.val);
                    if (value % 2 == 0) {
                        subArray.add(cur.val);
                    } else {
                        subArray.add(0, cur.val);
                    }
                    if (cur.left != null)
                        queue.add(new Pair<>(cur.left, value + 1));
                    if (cur.right != null)
                        queue.add(new Pair<>(cur.right, value + 1));
                }
            }
            res.add(subArray);
        }
        return res;
    }


}
