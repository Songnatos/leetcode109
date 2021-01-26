import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
    int[] num=new int[100];
    int count=0;
    for(int [] temp:dominoes) {
       int val=temp[0]>temp[1]?temp[0]*10+temp[1]:temp[1]*10+temp[0];
       count+=num[val];
       num[val]++;


    }

    return count;
    }


}