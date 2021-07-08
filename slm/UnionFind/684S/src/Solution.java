class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n=edges.length;
        int[] parent=new int[n+1];
        for(int i=0;i<n+1;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            if(!union(parent,edges[i][0],edges[i][1])){
                return edges[i];
            }
        }
        return null;
    }
    public int find(int[] parent,int x){
        if(x!=parent[x]){
            x=find(parent,parent[x]);
        }
        return parent[x];
    }
    public boolean union(int[] parent,int x,int y){
        int rootx=find( parent,x);
        int rooty=find(parent,y);
        if(rootx==rooty){
            return false;
        }else{
            parent[rootx]=rooty;
            return true;
        }
    }
}