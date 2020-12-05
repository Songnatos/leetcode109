import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        if(numRows<2){
            return  s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        boolean flag=true;//true 为往下
        int count=0;
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        char[] charcol=s.toCharArray();
        for(char a:charcol){
            if(count==0){
                flag=true;
            }
            if(count==numRows-1){
                flag=false;
            }
            if(flag){
                rows.get(count++).append(a);
            }else{
                rows.get(count--).append(a);
            }
        }
        String res=new String();
        for(int z=0;z<rows.size();z++){
            res+=rows.get(z);
        }
        return res;

    }
}