import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {//TODO:可以二分
    public double[] medianSlidingWindow(int[] nums, int k) {
    DoubleHeap doubleHeap=new DoubleHeap(k);
    for(int i=0;i<k;i++){
        doubleHeap.insert(nums[i]);
    }
    double[] res=new double[nums.length-k+1];
    res[0]=doubleHeap.getMedian();
    for(int i=k;i<nums.length;i++){
        doubleHeap.insert(nums[i]);
        doubleHeap.erase(nums[i-k]);
        res[i-k+1]=doubleHeap.getMedian();
    }
    return res;
    }
    class DoubleHeap{
        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private Map<Integer,Integer> DELAYED;//延迟删除的map
        int count;
        int bigsize,smallsize;//需要删除的数量
        public DoubleHeap(int n){
            small=new PriorityQueue<>((x,y)->y-x);
            large=new PriorityQueue<>((x,y)->x-y);
            count=n;
            DELAYED=new HashMap<>();
            smallsize=0;
            bigsize=0;
        }
        public double getMedian(){
            return (count%2==1?small.peek():((double)small.peek()+large.peek())/2);
        }
        public void insert(Integer num){
            if(small.isEmpty()||num<small.peek()){
                small.offer(num);
                smallsize++;
            }else{
                large.offer(num);
                bigsize++;
            }
            makeBalance();
        }
        public void erase(int num){
            DELAYED.put(num,DELAYED.getOrDefault(num,0)+1);
            if(num<=small.peek()){
                smallsize--;
                if(num==small.peek()){
                    prune(small);
                }
            }else{
                bigsize--;
                if(num==large.peek()){
                    prune(large);
                }
            }
        }
        public void prune(PriorityQueue<Integer> heap){
            while(!heap.isEmpty()){
                int num=heap.peek();
                if(DELAYED.containsKey(num)){
                    DELAYED.put(num,DELAYED.get(num)-1);
                    if(DELAYED.get(num)==0){
                        DELAYED.remove(num);
                    }
                    heap.poll();
                }else {break;}
            }
        }
        private void makeBalance(){
            if(smallsize>bigsize+1){
                large.offer(small.poll());
                smallsize--;
                bigsize++;
                prune(small);
            }else if(smallsize<bigsize){
                small.offer(large.poll());
                bigsize--;
                smallsize++;
                prune(large);
            }
        }
    }
}