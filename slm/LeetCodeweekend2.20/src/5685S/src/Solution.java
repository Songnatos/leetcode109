class Solution {
    public String mergeAlternately(String word1, String word2) {
    char[] char1=word1.toCharArray();
    char[] char2=word2.toCharArray();
    StringBuilder res=new StringBuilder();
    if(char1.length<1){
            return word2;
        }
        if(char2.length<1){
            return word1;
        }
        int start1=0;
        int start2=0;
    while(start1<char1.length&&start2<char2.length){
        res.append(char1[start1++]);
        res.append(char2[start2++]);
    }
    for(int i=start1;i<char1.length;i++){
        res.append(char1[i]);
    }
        for(int i=start2;i<char2.length;i++){
            res.append(char2[i]);
    }
        return res.toString();
}}