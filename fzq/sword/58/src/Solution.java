class Solution {
    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strings.length-1; i >= 0; i--) {
            if (!strings[i].equals(""))
                sb.append(strings[i]).append(" ");
        }
        return String.valueOf(sb).trim();
    }
}
