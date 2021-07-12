public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        System.out.println(solution.buildTree(preorder, inorder));
    }
}
