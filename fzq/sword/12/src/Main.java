public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
//        char[][] board = new char[][]  {{'a'}};
//        String word = "a";

        System.out.println(solution.exist(board, word));
    }
}
