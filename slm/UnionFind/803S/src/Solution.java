class Solution {
    int n,m;
    public static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        m=grid.length;
        n=grid[0].length;
        int[][] copy=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                copy[i][j]=grid[i][j];
            }
        }
        for(int[] hit:hits){
            copy[hit[0]][hit[1]]=0;
        }
        int size=m*n;
        UnionFind unionFind=new UnionFind(size+1);
        for(int i=0;i<n;i++){
            if(copy[0][i]==1){
                unionFind.union(node(0,i),size);
            }
        }
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(copy[i][j]==1){
                    if(copy[i-1][j]==1){
                        unionFind.union(node(i-1,j),node(i,j));
                    }
                    if(j>0&&copy[i][j-1]==1){
                        unionFind.union(node(i,j-1),node(i,j));
                    }
                }
            }
        }int hints= hits.length;
        int[] res=new int[hints];
        for(int i=hints-1;i>=0;i--){
            int x=hits[i][0];
            int y=hits[i][1];
            if(grid[x][y]==0)
                continue;
            int origin=unionFind.length(size);//补回
            if(x==0){//是第一行
                unionFind.union(y,size);
            }
            for(int[] dir:DIRECTIONS){
                int newX=x+dir[0];
                int newY=y+dir[1];
                if(InArea(newX,newY)&&copy[newX][newY]==1){
                    unionFind.union(node(newX,newY),node(x,y));
                }
            }
            int current=unionFind.length(size);
            res[i]=(current==origin)?0:current-origin-1;
            copy[x][y]=1;


        }
        return res;


    }
    public boolean InArea(int x,int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    public int node(int i,int j){
        return i*n+j;
    }
    public class UnionFind{
        public int[] parents;
        public int[] length;
        public UnionFind(int n){
            parents=new int[n];
            length=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                length[i]=1;
            }
        }
        public int find(int x){
            if(x!=parents[x]){
                parents[x]=find(parents[x]);
            }
            return parents[x];
        }
        public void union(int x, int y){
            int rootX=find(x);
            int rooty=find(y);
            if(rootX==rooty){
                return ;
            }
            parents[rootX]=rooty;
            length[rooty]+=length[rootX];
        }
        public int length(int x){
            int root=find(x);
            return length[root];
        }
    }
}