class Solution {
    private boolean[][] flag;
    public boolean exist(char[][] board, String word) {
        flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word.toCharArray(), i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int x, int y, int k) {
        if (flag[x][y] || board[x][y] != words[k++]) return false;
        if (k == words.length) return true;
        flag[x][y] = true;
        boolean res = (x+1 < board.length && dfs(board, words, x+1, y, k)) || (x > 0 && dfs(board, words, x-1, y, k))
                || (y > 0 && dfs(board, words, x, y-1, k)) || (y+1 < board[0].length && dfs(board, words, x, y + 1, k));
        flag[x][y] = false;
        return res;
    }
}
