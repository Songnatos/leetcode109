class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        UnionFind unionFind=new UnionFind(4*n*n);
        for(int i=0;i<n;i++){
            char[] row=grid[i].toCharArray();
            for(int j=0;j<n;j++){
                int index=4*(i*n+j);
                char c=row[j];
                if(c=='/'){
                    unionFind.union(index,index+3);
                    unionFind.union(index+1,index+2);
                }else if(c=='\\'){
                    unionFind.union(index,index+1);
                    unionFind.union(index+2,index+3);
                }else{
                    unionFind.union(index,index+1);
                    unionFind.union(index+1,index+2);
                    unionFind.union(index+2,index+3);
                }
                if(j+1<n){
                    unionFind.union(index+1,4*(i*n+j+1)+3);
                }
                if(i+1<n){
                    unionFind.union(index+2,4*((i+1)*n+j));
                }
            }

        }
        return unionFind.count;

    }
    public class UnionFind{
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
    public void union(int x,int y){
        int rx=find(x);
        int ry=find(y);
        if(rx==ry){
            return ;
        }
        parent[rx]=ry;
        count--;
    }
    }
}
