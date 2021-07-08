import jdk.nashorn.internal.ir.UnaryNode;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    int n=s.length();
    char[] temp=s.toCharArray();
    UnionFind unionFind= new UnionFind(n);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
    for(List<Integer> pair:pairs){
        unionFind.union(pair.get(0),pair.get(1));
    }
    for(int i=0;i<n;i++){
        int key=unionFind.find(i);
        map.computeIfAbsent(key,unused -> new ArrayList<>()).add(i);
    }
    StringBuilder res = new StringBuilder(s);
    for( List<Integer> list :map.values()){
        if(list.size()>1){
            sort(res,list);
        }

    }
    return res.toString();

    }
    public void sort(StringBuilder s,List<Integer> list){
        char[] arrar=new char[list.size()];
        for(int i=0;i<list.size();i++){
            arrar[i]=s.charAt(list.get(i));
        }
        Arrays.sort(arrar);
        for(int i=0;i<list.size();i++){
            s.setCharAt(list.get(i),arrar[i]);
        }
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