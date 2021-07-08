import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res=new ArrayList<>();
        int sum=0;
        for(Integer a:A){
            sum=((sum<<1)+a)%5;
            if(sum==0){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}