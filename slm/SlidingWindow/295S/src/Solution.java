import java.util.PriorityQueue;

class MedianFinder {
    int count;
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    /** initialize your data structure here. */
    public MedianFinder() {
        count=0;
    maxheap=new PriorityQueue<>((x,y)->y-x);
    minheap=new PriorityQueue<>();
    }

    public void addNum(int num) {
        count+=1;
    maxheap.offer(num);
    minheap.add(maxheap.poll());
    if(count%2==1){
        maxheap.add(minheap.poll());
    }
    }

    public double findMedian() {
    if(count%2==1){
        return (double)maxheap.peek();
    }else{
        return((double)minheap.peek()+(double)maxheap.peek())/2.0;
    }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */