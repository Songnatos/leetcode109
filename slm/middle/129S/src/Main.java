public class Main {


    public static void main(String[] args) {
        TreeNode a=new TreeNode(3);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(1);
        c.left=b;
        c.right=a;
        Solution solution = new Solution();
        solution.sumNumbers(c);
        System.out.println("Hello World!");
    }
}
