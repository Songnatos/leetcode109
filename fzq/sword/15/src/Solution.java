class Solution {
    public int hammingWeight(int n) {
        char[] chars = Integer.toBinaryString(n).toCharArray();
        int res = 0;
        for (char c : chars)
            res += c == '1' ? 1 : 0;
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0, i = 0;
        while (n != 0) {
            if ((n & (1<<i)) != 0) {
                res++;
            }
            n &= -1 - (1<<i++);
        }
        return res;
    }

    public int hammingWeight3(int n) {
        int res = 0;
        while (n != 0) {
            n &= n-1;
            res++;
        }
        return res;
    }
}
