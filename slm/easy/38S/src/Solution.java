import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str=countAndSay(n-1);
        StringBuilder res=new StringBuilder();
        int length=str.length();
        int start=0;
        for(int i=1;i<length+1;i++){
            if(i==length){
                res.append(i-start).append(str.charAt(start));
            }else if(str.charAt(i)!=str.charAt(i-1)){//找到不同的
                res.append(i-start).append(str.charAt(start));
                start=i;
            }
        }
        return res.toString();
    }
}