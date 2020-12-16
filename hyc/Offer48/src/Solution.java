// https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] index = new int[300];
        char[] str = s.toCharArray();
        int max = 1;
        int len = 0;
        int left = 0;

        for (int i = 0; i < str.length; i ++) {
            if (index[str[i]] != 0) {
                if (left < index[str[i]]) {
                    left = index[str[i]];
                    len = i + 1 - index[str[i]];
                } else {
                    len ++;
                }
                index[str[i]] = i + 1;
            } else {
                index[str[i]] = i + 1;
                len ++;
            }
            if (len > max) {
                max = len;
            }
        }
        return max > len ? max : len;
    }
}
