class Solution {
    public int cuttingRope(int n) {
        if (n <= 3)
            return n-1;
        long res = 1;
        int count = n / 3, a = n % 3;
        for (int i = 0; i < count-1; i++) {
            res = (res*3)%1000000007;
        }

        switch (a) {
            case 0:
                res = (res*3)%1000000007;
                break;
            case 1:
                res = (res*4)%1000000007;
                break;
            case 2:
                res = (res*6)%1000000007;
                break;
        }

        return (int) res;
    }
}
