import java.util.Arrays;

class Solution {
        public String removeDuplicateLetters(String s) {
            int[] temp=new int[26];
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)-'a']=1;
        }
       StringBuilder res=new StringBuilder();
        for(int i=0;i<26;i++){
            if(temp[i]==1){
                res.append((char)('a'+i));
            }
        }
        return res.toString();
    }
}