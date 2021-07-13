class Solution {

    /**
     * 维护4个指针的写法更好
     */

    private int[] a = new int[2];
    private int row, col, w;
    private boolean[][] flag;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return new int[]{};

        row = matrix.length;
        col = matrix[0].length;
        int length = row * col, i = 0;
        int[] res = new int[length];
        flag = new boolean[row][col];

        while (true) {
            res[i] = matrix[a[0]][a[1]];
            flag[a[0]][a[1]] = true;
            if (++i == length)
                break;
            way();
        }
        return res;
    }

    private void way() {
        switch (w) {
            case 0:
                if (a[1]+1 < col && !flag[a[0]][a[1]+1]) {
                    a[1]++;
                } else {
                    w = 1;
                    way();
                }
                break;
            case 1:
                if (a[0]+1 < row && !flag[a[0]+1][a[1]]) {
                    a[0]++;
                } else {
                    w = 2;
                    way();
                }
                break;
            case 2:
                if (a[1] > 0 && !flag[a[0]][a[1]-1]) {
                    a[1]--;
                } else {
                    w = 3;
                    way();
                }
                break;
            case 3:
                if (a[0] > 0 && !flag[a[0]-1][a[1]]) {
                    a[0]--;
                } else {
                    w = 0;
                    way();
                }
                break;
        }
    }
}
