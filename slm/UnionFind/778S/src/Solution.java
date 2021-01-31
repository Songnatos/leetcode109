class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        UnionFind unionFind=new UnionFind(m*n);
        for(int t=0;t<1000;t++){
            for(int  i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    for(int[] di:dir){
                        int tempi=i+di[0];
                        int tempj=j+di[1];
                        if(tempi>=0&&tempi<n&&tempj<m&&tempj>=0&&grid[i][j]<=t&&grid[tempi][tempj]<=t){
                            unionFind.union(i*n+j,tempi*n+tempj);
                            if(unionFind.isConnect(0,m*n-1)){
                                return i;
                            }
                        }
                    }

                }
            }
        }
    return 0;
    }
    public class UnionFind{
        int[] parents;
        public  UnionFind(int n){
            parents=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
            }
        }
        public int find(int x){
            if(x!=parents[x]){
                parents[x]=find(parents[x]);
            }
            return parents[x];
        }
        public void union(int x,int y){
            int rootx=find(x);
            int rooty=find(y);
            if(rootx!=rooty){
                parents[rootx]=rooty;
            }
        }
        public boolean isConnect(int x,int y){
            int rootx=find(x);
            int rooty=find(y);
            return rootx==rooty;
        }
    }

}