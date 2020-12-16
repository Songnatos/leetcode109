import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        for(int i=0;i<num.length();i++){
            while(k>0&&!deque.isEmpty()&&deque.getLast()>num.charAt(i)){
                deque.pollLast();
                k--;
            }
            deque.offerLast(num.charAt(i));
        }
        for(int i=0;i<k;i++){
            deque.pollLast();
        }
        StringBuilder res=new StringBuilder();
        boolean isZero=true;
        while(!deque.isEmpty()){
            char digit=deque.pollFirst();
            if(isZero&&digit=='0'){
                continue;
            }
            isZero=false;
            res.append(digit);
        }
        return res.length()==0?"0":res.toString();
    }
}

