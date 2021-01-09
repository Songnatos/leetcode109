import jdk.nashorn.internal.ir.UnaryNode;

import java.security.PublicKey;
import java.util.List;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    int n=s.length();
    char[] temp=s.toCharArray();
    UnionFind unionFind= new UnionFind(n);
    for(List<Integer> pair:pairs){
        unionFind.union(pair.get(0),pair.get(1));
    }
    for(int i=n-1;i>0;i--){
        for(int j=i-1;j>=0;j--){
            if(unionFind.find(i)==unionFind.find(j)&&temp[i]<temp[j]){
                char t=temp[i];
                temp[i]=temp[j];
                temp[j]=t;
            }
        }
    }
    return String.valueOf(temp);

    }
    public  class UnionFind{
        private int[] parent;
        public UnionFind(int n){
            parent=new int[n];
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
        public  void union(int x,int y){
            int rootx=find(x);
            int rooty=find(y);
            if(rootx!=rooty){
                parent[rootx]=rooty;
            }
        }
    }
}