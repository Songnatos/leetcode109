public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] rooms = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] startPoint = new int[]{0,0}, endPoint = new int[]{2,2};

        System.out.println(solution.minimumInitHealth(rooms, startPoint, endPoint));
    }
}
