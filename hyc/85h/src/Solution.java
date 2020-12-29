class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] countMap = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    countMap[i][j] = (j == 0 ? 0 : countMap[i][j-1]) + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = countMap[i][j];
                int area = countMap[i][j];
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, countMap[k][j]);
                    area = Math.max(area, width * (i - k + 1));
                }
                max = Math.max(max, area);
            }
        }
        return max;
    }
}