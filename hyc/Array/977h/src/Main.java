public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.sortedSquares(new int[]{-4,-1,0,3,10});
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
