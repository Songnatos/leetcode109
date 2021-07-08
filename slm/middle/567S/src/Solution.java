import java.util.Arrays;
import java.util.Collections;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
    char[] c1=s1.toCharArray();
    char[] c2=s2.toCharArray();
        Arrays.sort(c1);
        for(int i=0;i<c2.length-c1.length+1;i++){
            if(s1.contains(s2.subSequence(i,i+1))){
                char[] temp=s2.substring(i,i+s1.length()).toCharArray();
                Arrays.sort(temp);
                boolean flag=true;
                for(int j=0;j<c1.length;j++){
                    if(temp[j]!=c1[j]){
                        flag=false;
                    }
                }
                if(flag){
                    return flag;
                }
            }
        }
        return  false;
    }
}