import java.util.Arrays;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        UnionFind unionFind=new UnionFind(n);
        for(int i=0;i<connections.length;i++){
            unionFind.union(connections[i][0],connections[i][1]);
        }
        return unionFind.count-1;

    }
    public class UnionFind{
        int[] parents;
        int count;
        public UnionFind(int n){
            parents=new int[n];
            count=n;
            for(int i=0;i<n;i++){
                parents[i]=i;
            }
        }
        public int find(int x){
            if(parents[x]!=x){
                parents[x]=find(parents[x]);
            }
            return parents[x];
        }
        public void union(int x,int y){
            int rx=find(x);
            int ry=find(y);
            if(rx==ry){
                return;
            }
            parents[rx]=ry;
            count--;
        }
    }
    }
