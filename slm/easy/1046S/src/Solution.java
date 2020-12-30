import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        int dis= 0;
        while(pq.size()>1){
            dis=pq.poll()-pq.poll();
            if(dis>0){
                pq.offer(dis);
            }
        }
        return pq.isEmpty()?0 :pq.poll();
    }
}