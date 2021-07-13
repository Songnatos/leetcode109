class Solution {
    public int[] printNumbers(int n) {
        int max = new Double(Math.pow(10, n)).intValue()-1;
        int[] res = new int[max];
        for (int i = 0; i < max; i++)
            res[i] = i+1;
        return res;
    }
}
