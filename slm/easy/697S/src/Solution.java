import java.util.*;

class Solution {
public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
        map.computeIfAbsent(nums[i],unused -> new ArrayList<>()).add(i);
        }
        int maxnum=0;
        int res=nums.length;
        for(Integer temp:map.keySet()){
        if(map.get(temp).size()>=maxnum){
        Collections.sort(map.get(temp));
        if(map.get(temp).size()==1){
                res=nums.length;
                }else{
                if(map.get(temp).size()>maxnum){
                        res=map.get(temp).get(map.get(temp).size()-1)-map.get(temp).get(0)+1;
                }else{
        res=Math.min(res, map.get(temp).get(map.get(temp).size()-1)-map.get(temp).get(0)+1);}}
        maxnum=map.get(temp).size();
        }
        }
        return res;
        }
}