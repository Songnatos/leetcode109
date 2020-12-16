class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] str = String.valueOf(N).toCharArray();
        for (int i = str.length-1; i > 0; i--) {
            char now = str[i], front = str[i-1];
            if (now < front) {
                for (int j = i; j < str.length; j++) {
                    str[j] = '9';
                }
                str[i-1]--;
            }
        }
        int res = Integer.parseInt(String.copyValueOf(str));

        return res;
    }
}
