import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    List<List<Integer>> map =new ArrayList<>();
    int[] list;
    int res;
    boolean[] visited;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        list=new int[n];
        visited=new boolean[n];
        visited[0]=true;
        Arrays.fill(list,-1);
        res=0;
        for(int i=0;i<n;i++){
            map.add(new ArrayList<>());
        }
        for(int[] edg:edges){
            map.get(edg[0]).add(edg[1]);
            map.get(edg[1]).add(edg[0]);
        }
        MaptoArrary(map,0);
        for (int i = 0; i < n; i++) {
            if (hasApple.get(i)) {
                dfsEdge(i);
            }
        }
        return res*2;

    }
    public void dfsEdge(int val){
        if(!visited[val]){
            visited[val]=true;
            res++;
            dfsEdge(list[val]);
        }
    }
    public void MaptoArrary(List<List<Integer>> map,int val){
    for(Integer pair:map.get(val)){
        if(pair!=0&&list[pair]==-1){
            list[pair]=val;
            MaptoArrary(map,pair);
        }
    }
    }
}