import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int parent[]=new int[isConnected.length];
        Arrays.fill(parent,-1);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[i][j]==1&&i!=j){
                    union(parent,i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<isConnected.length;i++){
            if(parent[i]==-1){
                count++;
            }
        }
        return count;

    }
    public  void union(int[] parent ,int x,int y){
        if(find(parent,x)!=find(parent,y))
        parent[find(parent, x)] = find(parent, y);
    }
    public int find(int[] parent,int j){
        if(parent[j]==-1){
            return j;
        }else{
            return  find(parent,parent[j]);
        }
    }
}