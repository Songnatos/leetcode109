class Solution {
    public String replaceSpace(String s) {
        char[] cs = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : cs) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
