class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] r = new int[cost.length];
        r[0] = cost[0];
        r[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            r[i] = Math.min(r[i-1], r[i-2]) + cost[i];
        }
        return Math.min(r[r.length-1], r[r.length-2]);
    }
}
