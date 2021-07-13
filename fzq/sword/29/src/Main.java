import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }
}
