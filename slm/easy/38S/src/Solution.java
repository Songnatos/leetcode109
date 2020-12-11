import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {//思路错误 不对
    public String countAndSay(int n) {
        Queue<Integer> num=new LinkedList<Integer> ();;
        while(n!=0){
            num.offer(n%10);
            n=n/10;
        }
        StringBuilder res=new StringBuilder();

        while(!num.isEmpty()){
            int count=1;
            int temp=num.poll();
            while(num.peek()==temp){
                num.poll();
                count++;
            }
            res.append(count);res.append(temp);
        }
        return res.toString();
    }
}