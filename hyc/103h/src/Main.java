import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> temp = Arrays.asList("3","9","20","null","null","15","7");
        TreeNode root = solution.buildTree(temp);
        System.out.println(solution.zigzagLevelOrder(root));
    }
}
