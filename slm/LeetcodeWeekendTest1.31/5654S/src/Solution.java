import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] num=new int[1000];
        Arrays.fill(num,0);
    for(int i=lowLimit;i<highLimit+1;i++){
        int n=getNum(i);
        num[n]++;
    }
    int max=Integer.MIN_VALUE;
    for(int i=0;i<1000;i++){
        if(num[i]>max){
            max=num[i];
        }
    }
    return max;
    }
    public int getNum(int n){
        int count=0;
        while(n!=0){
            count+=n%10;
            n=n/10;
        }
        return count;
    }
}