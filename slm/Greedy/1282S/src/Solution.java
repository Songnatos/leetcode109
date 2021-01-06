import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,List<Integer>> temp=new HashMap<>();
        for(int i=0;i<groupSizes.length;i++){
            if(temp.containsKey(groupSizes[i])){
                temp.get(groupSizes[i]).add(i);
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                temp.put(groupSizes[i],list);
            }
        }
        for(Integer a: temp.keySet()){
            List<Integer> roll=new ArrayList<>();
           for(int i=0;i<temp.get(a).size();i++){
               roll.add(temp.get(a).get(i));
               if(roll.size()==a){
                   List<Integer>  tt= (List<Integer>) ((ArrayList<Integer>) roll).clone();
                   roll.clear();
                   res.add(tt);
               }
           }
        }
        return res;
    }
}