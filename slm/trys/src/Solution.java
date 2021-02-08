import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> res=new PriorityQueue<>((x,y)->y-x);
        res.add(a);res.add(b);res.add(c);
        int count=0;
        int sum=0;
        for(Integer num:res){
            if(num<=0){
                count++;
            }
        }
        while(count<2){
            count=0;
            sum++;
            int temp1=res.poll();
            int temp2=res.poll();
            res.add(--temp1);
            res.add(--temp2);
            for(Integer num:res){
                if(num<=0){
                    count++;
                }
            }
        }
        return sum;

    }
}