import java.util.ArrayDeque;

class Solution {
    static final int[][]dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] highestPeak(int[][] isWater) {
        int level=0;
        ArrayDeque<int[]> que=new ArrayDeque<>();
        ArrayDeque<int[]> que2=new ArrayDeque<>();
        int m=isWater.length;
        int n=isWater[0].length;
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]!=1){
                    res[i][j]=-1;
                }else{
                    que.offer(new int[]{i,j});
                }
            }
        }
        while(que.size()>0){
            ArrayDeque<int[]> tmp = que2;
            que2 = que;
            que = tmp;
            ++level;
        while(que2.size()>0){
            int[] temp=que2.poll();
            for(int i=0;i<4;i++){
                int x=temp[0]+dir[i][0];
                int y=temp[1]+dir[i][1];
                if(x<0||x>=m||y<0||y>=n){
                    continue;
                }else{
                    if(res[x][y]==-1){
                        que.offer(new int[]{x,y});
                        res[x][y]=level;
                    }
                }
            }

        }
    }
        return res;
    }
}