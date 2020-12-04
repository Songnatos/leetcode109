import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,new PriorityQueue<Integer>());
            }
            if(map.containsKey(i-1)){
                int length=map.get(i-1).poll();
                if(map.get(i-1).isEmpty()){
                    map.remove(i-1);
                }

                map.get(i).add(length+1);
            }else{
                map.get(i).add(1);
            }
        }
        Set<Map.Entry<Integer,PriorityQueue<Integer>>> entries=map.entrySet();
        for(Map.Entry<Integer, PriorityQueue<Integer>> entirty:entries){
            PriorityQueue<Integer> queue = entirty.getValue();
            if (queue.peek() < 3) {
                return false;
            }

        }
        return true;
    }
}
