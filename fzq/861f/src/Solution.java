class Solution {
    public int matrixScore(int[][] A) {
        for (int[] a : A) {
            if (a[0] == 0) {
                for (int i = 0; i < a.length; i++) {
                    a[i] = a[i] == 0 ? 1 : 0;
                }
            }
        }

        int score = 0, mid = A.length/2;
        for (int j = A[0].length - 1; j >= 0; j--) {
            int col = 0;
            for (int i = 0; i < A.length; i++) {
                col += A[i][j];
            }
            if (col <= mid) {
                col = A.length - col;
            }
            score += col * (1 << A[0].length - 1 - j);
        }

        return score;
    }
}
