class Solution {
    int m, n;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void solve(char[][] board) {
        if(board==null|| board.length == 0)return ;
        m=board.length;
        n=board[0].length;
        UnionFind unionFind=new UnionFind(m*n+1);
        int dummy=m*n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (board[i][j] == 'O') {
                    if(i==0||j==0||i==m-1||j==n-1){
                        unionFind.union(node(i,j),dummy);
                    }else{
                        for(int k=0;k<directions.length;k++){
                            int tempi=i+directions[k][0];
                            int tempj=j+directions[k][1];
                            if((tempi > 0 || tempi < m || tempj > 0 || tempj < n) && board[tempi][tempj] == 'O')
                                unionFind.union(node(i,j),node(tempi,tempj));
                        }
                    }
                }}
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(unionFind.find(node(i,j))!=unionFind.find(dummy)){
                    board[i][j]='X';
                }
            }
        }

    }
    public int node(int x,int y){
        return x*n+y;
    }
    public class UnionFind{
        private int[] parent;
        private int[] rank;
        public UnionFind(int n){
            parent=new int[n];
            rank=new int[n];
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
            if(rank[rootX]>rank[rootY]) parent[rootY]=rootX;
            if (rank[rootX]<rank[rootY]) parent[rootX]=rootY;
            if (rank[rootX]==rank[rootY]){
                parent[rootY]=rootX;
                rank[rootX]++;
            }
        }
    }
}