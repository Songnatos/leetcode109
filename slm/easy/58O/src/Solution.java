class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res= new StringBuilder();
        res.append(s.substring(n,s.length()));
        res.append(s.substring(0,n));
        return res.toString();
    }
}