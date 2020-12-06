import java.util.ArrayList;
import java.util.List;

class Solution {//杨辉三角
    public List<List<Integer>> generate(int numRows) {
        if(numRows==0){
            return new ArrayList<>();
        }
        List<List<Integer>> res=new ArrayList<>();
        int i=1;
        List<Integer> first=new ArrayList<>();
        first.add(1);res.add(first);
        List<Integer> lasttemp=new ArrayList<>();
        while(i!=numRows){
            List<Integer> temp=new ArrayList<>();

            temp.add(1);
            if(i==1){
                temp.add(1);
            }else{
                for(int j=0;j<i-1;j++){
                    temp.add(lasttemp.get(j)+lasttemp.get(j+1));
                }
                temp.add(1);
            }
            lasttemp=temp;
            res.add(temp);
            i++;
        }
        return res;
    }
}
