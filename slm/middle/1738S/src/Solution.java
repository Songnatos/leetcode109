
import java.util.PriorityQueue;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        PriorityQueue<Integer> queue= new PriorityQueue<Integer>();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=dp[i-1][j-1]^dp[i][j-1]^dp[i-1][j]^matrix[i-1][j-1];
                queue.offer(dp[i][j]);
                if(queue.size()>k){
                    queue.poll();
                }
            }
        }
        return queue.peek();

    }
}