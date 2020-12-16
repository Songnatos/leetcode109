import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists=new ArrayList<>();
        Map<String,List<String>> res=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] temp=strs[i].toCharArray();
            Arrays.sort(temp);
            String tempstr=String.valueOf(temp);
            if(res.containsKey(tempstr)){
                res.get(tempstr).add(strs[i]);
            }else{
                res.put(tempstr, new ArrayList<>());
                res.get(tempstr).add(strs[i]);
            }
        }
        for(String a:res.keySet()){
            lists.add(res.get(a));
        }
        return lists;
    }
}