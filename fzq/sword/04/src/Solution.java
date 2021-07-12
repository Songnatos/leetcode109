class Solution {

    private boolean[][] flag;

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = 0;
        while (i < row && j < col) {
            if (matrix[i][j] == target)
                return true;
            if (j < col - 1) {
                if (matrix[i][j+1] <= target) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        flag = new boolean[matrix.length][matrix[0].length];
        return dfs(matrix, target, 0, 0);
    }

    private boolean dfs(int[][] matrix, int target, int x, int y) {
        if (flag[x][y]) {
            return false;
        }
        flag[x][y] = true;
        if (matrix[x][y] == target)
            return true;
        if (matrix[x][y] > target)
            return false;
        if (x+1 < matrix.length && dfs(matrix, target, x+1, y))
                return true;
        return y + 1 < matrix[0].length && dfs(matrix, target, x, y + 1);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }


}
