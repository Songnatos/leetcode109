import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        int count=0;
        UnionFind unionFindAlice=new UnionFind(n);//Alice
        UnionFind unionFindbob=new UnionFind(n);//bob
        for(int i=0;i<edges.length;i++){
            if(edges[i][0]==3){
                if(!unionFindAlice.union(edges[i][1]-1,edges[i][2]-1)){
                    count++;
                }
                unionFindbob.union(edges[i][1]-1,edges[i][2]-1);
            }
            else if(edges[i][0]==1){
                if(!unionFindAlice.union(edges[i][1]-1,edges[i][2]-1)){
                    count++;
                }
            }
            else{
                if( !unionFindbob.union(edges[i][1]-1,edges[i][2]-1)){
                    count++;
                }
            }
        }
        if(unionFindAlice.count!=1||unionFindbob.count!=1){
            return -1;
        }
        return count;


    }
    public  class UnionFind{
        int[] parent;
        int count;
        public UnionFind(int n){
            parent=new int[n];
            count=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public  int find(int x){
            if(x!=parent[x]){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public boolean union(int x,int y){
            int rx=find(x);
            int ry=find(y);
            if(rx==ry){return false;}
            parent[rx]=ry;
            count--;
            return true;
        }
    }
}