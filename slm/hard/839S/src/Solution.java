class Solution {
    public int numSimilarGroups(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        UnionFind unionFind=new UnionFind(n);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(!unionFind.isconnected(i,j)){
                    if(fimilar(strs[i],strs[j],m)){
                        unionFind.union(i,j);
                    }
                }
            }
        }
        return unionFind.count;

    }
    public boolean  fimilar(String a,String b,int length){
        int count=0;
        for(int i=0;i<length;i++){
            char ca=a.charAt(i);
            char cb=b.charAt(i);
            if(ca!=cb){
                count++;
                if(count>2){
                    return false;
                }
            }
        }
        return  true;
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
        public   boolean isconnected(int x,int y){
            int rx=find(x);
            int ry=find(y);
            return rx==ry;
        }
    }
}