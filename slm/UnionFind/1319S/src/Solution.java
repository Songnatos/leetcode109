import java.util.Arrays;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        boolean[] isVisted=new boolean[n];
        int parent[]=new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(isVisted,false);
        for(int i=0;i<connections.length;i++){
            union(parent,connections[i][1],connections[i][0]);
                    isVisted[connections[i][1]]=true;
                    isVisted[connections[i][0]]=true;
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(parent[i]==-1){
                count++;
            }
        }

        return count==1?-1:count-1;

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
