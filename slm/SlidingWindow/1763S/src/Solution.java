import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        if(n<2){
            return "";
        }
        String res="";
        for(int len=2;len<s.length();len++){
            for(int i=0;i+len-1<n;i++){
                String sub=s.substring(i,i+len);
                if(sub.length()>res.length()&&isnice(sub)){
                    res=sub;
                }

            }
        }
        return res;
    }
    public boolean isnice(String s){
        HashSet<Character> high=new HashSet<>();
        HashSet<Character> low=new HashSet<>();
        char[] temp=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(Character.isUpperCase(temp[i])){
                high.add(temp[i]);
            }else{
                low.add(Character.toUpperCase( temp[i]));
            }
        }
        if(low.size()!=high.size()){
            return false;
        }
        high.removeAll(low);
        return high.size()==0;
    }
}