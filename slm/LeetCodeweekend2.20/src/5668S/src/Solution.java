import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    String res=new String();
    public String longestNiceSubstring(String s) {
    char[] ss=s.toCharArray();
    if(ss.length<2){
        return "";
    }
    n=ss.length;
    int start=0;int end=1;
    boolean[] big=new boolean[26];
    boolean[] small=new boolean[26];
    for(int i=0;i<n;i++){
        if(ss[i]>='A'&&ss[i]<='Z'){
            big[ss[i]-'A']=true;
        }else if(ss[i]>='a'&&ss[i]<='z'){
            small[ss[i]-'a']=true;
        }
    }
        List<String> res=new ArrayList<>();
    StringBuilder t=new StringBuilder();
    for(int i=0;i<n;i++){
        int num=0;
        if(ss[i]>='A'&&ss[i]<='Z'){
            num=ss[i]-'A';
        }else if(ss[i]>='a'&&ss[i]<='z'){
            num=ss[i]-'a';
        }
        if(big[num]&&small[num]){
            t.append(s.charAt(i));
        }else{
            res.add(t.toString());
            t=new StringBuilder();
        }
    }
        res.add(t.toString());
    return res.get(0);

    }
    public int find(int x,boolean[] big,boolean[] small,char[] ss){
        int end=x;
        while(end<n-1&&big[end]&&small[end]){
            end++;
        }
        if(!big[end]||!small[end]){
            return --end;
        }else{return end;}
    }

}