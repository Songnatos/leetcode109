import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp0=new ArrayList<>();
        temp0.add(1);
        res.add(temp0);
        while(res.size()<=rowIndex){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            List<Integer> last=res.get(res.size()-1);
            for(int i=1;i<last.size();i++){
                temp.add(last.get(i-1)+last.get(i-1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res.get(res.size()-1);

    }
}