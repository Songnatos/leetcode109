class Solution {
    private int count = 0;
    private int[][] flag;

    public int movingCount(int m, int n, int k) {
        flag = new int[m][n];
        dfs(0, 0, k);
        return count;
    }

    private void dfs(int i, int j, int k) {
        if (flag[i][j] != 0) return;
        if (canIn(i, j, k)) {
            flag[i][j] = 1;
            count++;
            if (i < flag.length-1) dfs(i+1, j, k);
            if (i > 0) dfs(i-1, j, k);
            if (j < flag[0].length-1) dfs(i, j+1, k);
            if (j > 0) dfs(i, j-1, k);
        } else {
            flag[i][j] = -1;
        }
    }
    
    private boolean canIn(int i, int j, int k) {
        return k >= calc(i) + calc(j);
    }

    private int calc(int x) {
        return x < 100 ? (x % 10 + x / 10) : 1;
    }
}
