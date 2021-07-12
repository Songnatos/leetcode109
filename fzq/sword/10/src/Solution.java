class Solution {
    public int fib2(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int f2 = 0, f1 = 1, f = 1;
        for (int i = 1; i < n; i++) {
            f = (f1 + f2) % 1000000007;
            f2 = f1;
            f1 = f;
        }
        return f;
    }

    public int fib(int n) {
        int[] dp = new int[101];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
