import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        UnionFind unionFind=new UnionFind(n);
        List<Edge> edges=new ArrayList<Edge>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                edges.add(new Edge(Dist(points,i,j),i,j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len-o2.len;
            }
        });
        int res=0,num=1;
        for(Edge edge:edges){
            int len=edge.len;
            int x=edge.x;
            int y=edge.y;
            if(unionFind.Union(x,y)){
                res+=len;
                num++;
                if(num==n){
                    break;
                }
            }

        }
        return res;
    }
    public int Dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }

    class UnionFind{
        int[] parents;
        int[] rank;
        int n;
        public UnionFind(int n){
            parents=new int[n];
            rank=new int[n];
            this.n=n;
            for(int i=0;i<n;i++){
                parents[i]=i;
                rank[i]=1;
            }
        }
        public int find(int x){
            if(x!=parents[x]){
                parents[x]=find(parents[x]);
            }

            return parents[x];
        }
        public boolean Union(int x,int y){
            int rootx=find (x);
            int rooty=find(y);
            if(rootx==rooty){
                return false;
            }
            if(rank[x]<rank[y]){
                int temp=rootx;
                rootx=rooty;
                rooty=temp;
            }
            rank[rootx]+=rank[rooty];
            parents[rooty]=rootx;
            return true;
        }
    }
    class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

}