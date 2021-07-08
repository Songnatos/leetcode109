import java.util.List;
import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> que=new PriorityQueue<>((x,y)->y-x);
    public KthLargest(int k, int[] nums) {
        this.k=k;
    for(Integer num:nums){
        que.add(num);
    }
    while(que.size()>k){
        que.poll();
    }
    }

    public int add(int val) {
    que.add(val);
        while(que.size()>k){
            que.poll();
        }
        return que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */