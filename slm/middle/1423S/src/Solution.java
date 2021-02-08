import java.util.Arrays;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
   int n=cardPoints.length;
   int min=Integer.MAX_VALUE;
   int sum=0;
   int windowsize=n-k;
   for(int i=0;i<windowsize;i++){
        sum+=cardPoints[i];
   }
   int mincount=sum;
        for (int i = windowsize; i < n; ++i) {
            // 滑动窗口每向右移动一格，增加从右侧进入窗口的元素值，并减少从左侧离开窗口的元素值
            sum += cardPoints[i] - cardPoints[i - windowsize];
            mincount = Math.min(mincount, sum);
        }
   return Arrays.stream(cardPoints).sum()-mincount;
    }

}
