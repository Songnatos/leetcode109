public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode n1 = new TreeNode(37);
        TreeNode n2 = new TreeNode(-34);
        TreeNode n3 = new TreeNode(-48);
        TreeNode n4 = new TreeNode(-100);
        TreeNode n5 = new TreeNode(-101);
        TreeNode n6 = new TreeNode(48);
        TreeNode n7 = new TreeNode(-54);
        TreeNode n8 = new TreeNode(-71);
        TreeNode n9 = new TreeNode(-22);
        TreeNode n10 = new TreeNode(8);
        n1.left = n2; n1.right = n3;
        n2.right = n4; n3.left = n5; n3.right = n6;
        n6.left = n7;
        n7.left = n8; n7.right = n9;
        n9.right = n10;

        System.out.println(solution.lowestCommonAncestor(n1, n8, n6).val);
    }
}
