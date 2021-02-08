import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res=new ArrayList<>();
        int level=1;
        res.add(label);
        while(label>(Math.pow(2,level)-1)){
            level++;
        }
        while(level>1){
            if(level%2!=0){
                label= (int) (Math.pow(2,level-1)-1-(int)(label-Math.pow(2,level-1))/2);
                res.add(label);
            }else{
                label= (int) (Math.pow(2,level-2)+(int)(Math.pow(2,level)-1-label)/2);
                res.add(label);
            }
            level--;
        }
        Collections.reverse(res);
        return res;
    }
}