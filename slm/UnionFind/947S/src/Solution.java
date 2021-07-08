import java.util.HashSet;
import java.util.Set;

class Solution {
    public int removeStones(int[][] stones) {
        int N=stones.length;
        UNionFind uNionFind=new UNionFind(20000);
        for(int[] stone:stones){
            uNionFind.union(stone[0],stone[1]+10000);
        }
        Set<Integer> res=new HashSet<>();
        for(int[] stone:stones){
            res.add(uNionFind.find(stone[0]));
        }
        return N-res.size();

    }
    public  class UNionFind{
        int[] parent;
        public UNionFind(int n){
            parent=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int find(int x ){
            if(x!=parent[x]){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x,int y){
            parent[find(x)]=find(y);

        }
    }
}