class Solution {

    public int minimumInitHealth(int[][] rooms, int[] startPoint, int[] endPoint) {
        int mins = 1, maxs = Integer.MAX_VALUE;
        int x = startPoint[0], y = startPoint[1], xe = endPoint[0], ye = endPoint[1];
        int m = rooms.length, n = rooms[0].length;
        boolean[][] flag = new boolean[m][n];

        while (mins < maxs) {
            int mid = (mins+maxs)/2;
//            System.out.println(mid);
            if(trydo(mid, flag, rooms, m, n, startPoint[0], startPoint[1], endPoint[0], endPoint[1]))
                maxs = mid;
            else mins = mid + 1;
        }

        return mins;
    }

    private boolean trydo(int H, boolean[][] flag, int[][] rooms, int m, int n, int nowFirst, int nowSecond, int endFirst, int endSecond) {
        int[] dx = new int[]{1,0,-1,0}, dy = new int[]{0,1,0,-1};
        H += rooms[nowFirst][nowSecond];
        if (H <= 0)
            return false;
        if (nowFirst == endFirst && nowSecond == endSecond)
            return true;
        flag[nowFirst][nowSecond] = true;
        for (int k = 0; k < 4; k++) {
            int x = nowFirst + dx[k], y = nowSecond + dy[k];
            if(x<0||y<0||x>=m||y>=n)continue;
            if(flag[x][y])
                continue;
            if(trydo(H, flag, rooms, m, n, x, y, endFirst, endSecond)){
                flag[nowFirst][nowSecond]=false;
                return true;
            }
        }
        flag[nowFirst][nowSecond] = false;
        return false;
    }
}
