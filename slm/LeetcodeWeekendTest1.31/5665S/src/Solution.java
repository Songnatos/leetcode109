import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
    int n=adjacentPairs.length;
    boolean[] seen=new boolean[n];
    int[] result=new int[n+1];
    Map<Integer, List<Integer>> res=new HashMap<>();
    for(int i=0;i<n;i++){
        res.computeIfAbsent(adjacentPairs[i][0],unused -> new ArrayList<>()).add(i);
        res.computeIfAbsent(adjacentPairs[i][1],unused -> new ArrayList<>()).add(i);
    }
    int temp=0;
    for(Integer key:res.keySet()){
        if(res.get(key).size()==1){
            result[0]=key;
            temp=res.get(key).get(0);
        }
    }
    int index=1;
    while(index!=n+1){
        int[] num=adjacentPairs[temp];
        seen[temp]=true;
        if(num[0]==result[index-1]){
            result[index]=num[1];
        }else{
            result[index]=num[0];
        }
        for(int i=0;i<res.get(result[index]).size();i++){
           if(!seen[res.get(result[index]).get(i)]){
               temp=res.get(result[index]).get(i);
           }
        }

        index++;

    }
    return result;
    }
}