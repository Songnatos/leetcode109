import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
         int maxcount=0;
         int[] count=new int[26];
         for(int i=0;i<tasks.length;i++){
             count[tasks[i]-'A']++;
         }
        Arrays.sort(count);
        for(int i=25;i>1;i++){
            if(count[i]==count[i-1]){
                maxcount++;
            }else{
                break;
            }
        }
        int res=(n+1)*count[25]+maxcount;
        return Math.max(res,tasks.length);
    }
}