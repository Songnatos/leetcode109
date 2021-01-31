import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
    int m=heights.length;
    int n=heights[0].length;
    if(m<2||n<2){
        return 0;
    }
    List<int[]> edges = new ArrayList<int[]>();
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            int id=i*n+j;
            if(i>0){
                edges.add(new int[]{id-n,id,Math.abs(heights[i][j]-heights[i-1][j])});
            }
            if(j>0){
                edges.add(new int[]{id-1,id,Math.abs(heights[i][j]-heights[i][j-1])});
            }
        }
        }
    Collections.sort(edges, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[2]-o2[2];
        }
    });
    UnionFind unionFind=new UnionFind(m*n);
    for(int[] edg:edges){
        unionFind.union(edg[0],edg[1]);
        if(unionFind.isConected(0,m*n-1)){
            return edg[2];
        }
    }
    return 0;

    }//用并查集做
    public class UnionFind{
        private int[] parent;
        public UnionFind(int n){
            parent=new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            if(rootX==rootY)return;
                parent[rootY]=rootX;
        }
        public boolean isConected(int x, int y) {
            int rootx=find(x);
            int rooty=find(y);
            return rootx==rooty;
        }
    }
}