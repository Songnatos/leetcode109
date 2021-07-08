

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int  m=edges.length;
        int[][] copys=new int[m][4];
        for(int i=0;i<m;i++){
            copys[i][0]=edges[i][0];
            copys[i][1]=edges[i][1];
            copys[i][2]=edges[i][2];
            copys[i][3]=i;
        }
        Arrays.sort(copys, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int v=0;//最佳权重
        UnionFind unionFind=new UnionFind(n);
        for(int i=0;i<m;i++){
            if(unionFind.union(copys[i][0],copys[i][1])){
                v+=copys[i][2];
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < 2; ++i) {
            res.add(new ArrayList<Integer>());
        }

        for(int i=0;i<m;i++){
            UnionFind unionFind1=new UnionFind(n);
            int value=0;
            for(int j=0;j<m;j++){//判断是否关键边
                if(i!=j&&unionFind1.union(copys[j][0],copys[j][1])){
                    value+=copys[j][2];
                }
            }
            if(unionFind1.setcount!=1||(unionFind1.setcount==1&&v<value)){//不再联通或者联通后权重变多
                res.get(0).add(copys[i][3]);
                continue;
            }
            unionFind1=new UnionFind(n);
            unionFind1.union(copys[i][0],copys[i][1]);
            value=copys[i][2];
            for(int j=0;j<m;j++){//判断是否伪关键边
                if(i!=j&&unionFind1.union(copys[j][0],copys[j][1])){
                    value+=copys[j][2];
                }
            }
            if(v==value){
                res.get(1).add(copys[i][3]);
            }
        }
        return res;

    }
    public class  UnionFind{
        int[] parents;
        int[] size;
        int n;
        int setcount;
        public UnionFind(int n){
            parents=new int[n];
            this.n=n;
            this.setcount=n;
            size=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                size[i]=1;
            }
        }
        public int find(int x){
            return parents[x]==x?x:(parents[x]=find(parents[x]));
        }
        public boolean union(int x,int y){
            int rx=find(x);
            int ry=find(y);
            if(rx==ry)return false;
            if(size[rx]<size[ry]){
                int temp=ry;
                ry=rx;
                rx=temp;
            }
            parents[ry]=rx;
            size[rx]+=size[ry];
            setcount--;
            return true;
        }
        public boolean connected(int x ,int y){
            int rx=find(x);
            int ry=find(y);
            if(rx==ry)return true;
            return false;
        }
    }
}