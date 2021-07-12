public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
//        int[][] matrix = new int[][]{{-1,3}};
//        int target = 3;
        System.out.println(solution.findNumberIn2DArray(matrix, target));
    }
}
