import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int monotoneIncreasingDigits(int N) {//最小栈
        while(!IsIncreasing(N)){
        String n= String.valueOf(N);
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n.length()-1;i++){
            if(n.charAt(i)>n.charAt(i+1)){
               res.append(n.substring(0,i));
               res.append(n.charAt(i)-'0'-1);
               for(int j=i;j<n.length()-1;j++){
                   res.append(9);
               }
               break;
            }
        }
        N=Integer.valueOf(res.toString());
        }
        return N;
    }
    public boolean IsIncreasing(int num){
        String n= String.valueOf(num);
        for(int i=0;i<n.length()-1;i++){
            if(n.charAt(i)>n.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

}
//    public int monotoneIncreasingDigits(int N) {//最小栈
//        while(!IsIncreasing(N)){
//            N--;
//        }
//        return N;
//
//    }
//    public boolean IsIncreasing(int num){
//        String n= String.valueOf(num);
//        for(int i=0;i<n.length()-1;i++){
//            if(n.charAt(i)>n.charAt(i+1)){
//                return false;
//            }
//        }
//        return true;
//    }