import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i=0;i<group.length;i++){
            if(group[i]==-1){
                group[i]=m++;
            }
        }
        List<Integer>[] GroupAdj=new ArrayList[m];
        List<Integer>[] itemAdj=new ArrayList[n];//实例化组和邻接表
        for(int i=0;i<m;i++){
            GroupAdj[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            itemAdj[i]=new ArrayList<>();
        }
        int[] groupIndegress=new int[m];
        int[] itemIndegress=new int[n];
        int len=group.length;
        for(int i=0;i<len  ;i++){//记录组关系
            int currentG=group[i];
            for(int beforeItem:beforeItems.get(i)){
                int beforeGroup=group[beforeItem];
                if(beforeGroup!=currentG){
                    GroupAdj[beforeGroup].add(currentG);
                    groupIndegress[currentG]++;
                }

            }
        }
        for(int i=0;i<n;i++){//记录项目的关系
            for(Integer item:beforeItems.get(i)){
                itemAdj[item].add(i);
                itemIndegress[i]++;
            }
        }
        //两次拓扑排序
        List<Integer> groupList=TopolSort(GroupAdj,groupIndegress,m);
        if(groupList.size()==0){
            return  new int[0];
        }
        List<Integer> itemList=TopolSort(itemAdj,itemIndegress,n);
        if(itemList.size()==0){
            return  new int[0];
        }
        Map<Integer,List<Integer>> group2Item=new HashMap<>();
        for(Integer item:itemList){
            group2Item.computeIfAbsent(group[item],key->new ArrayList<>()).add(item);
        }
        List<Integer> res=new ArrayList<>();
        for(Integer groupid:groupList){
            List<Integer> items=group2Item.getOrDefault(groupid,new ArrayList<>());
            res.addAll(items);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();


    }
    public List<Integer> TopolSort(List<Integer>[] adj,int[] indegree,int length){
        List<Integer> res= new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int u=queue.poll();
            res.add(u);
            for(Integer succssor:adj[u]){
                indegree[succssor]--;
                if(indegree[succssor]==0){
                    queue.offer(succssor);
                }
            }
        }
        return res.size()==length?res:new ArrayList<>();
    }
}