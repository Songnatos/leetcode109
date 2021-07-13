class Solution {
    public int add2(int a, int b) {
        return Math.addExact(a, b);
    }

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
