
import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer,List<String>> res=new HashMap<>();
        UnionFind unionFind=new UnionFind();
        Map<String,String> emailtoName=new HashMap<>();
        Map<String,Integer> emailToId=new HashMap<>();
        int id=0;
        for(List<String> account:accounts){
            String name="";
            for(String str:account){
                if(name==""){
                    name=str;
                    continue;
                }
                    emailtoName.put(str,name);
                    if(!emailToId.containsKey(str)){
                        emailToId.put(str,id++);
                    }
                    unionFind.union(emailToId.get(account.get(1)),emailToId.get(str));

            }
        }
        for(String email:emailtoName.keySet()){
            int index=unionFind.find(emailToId.get(email));
            res.computeIfAbsent(index,x->new ArrayList<>()).add(email);
        }
        for(List<String> emails:res.values()){
            Collections.sort(emails);
            emails.add(0,emailtoName.get(emails.get(0)));
        }
        return new ArrayList<>(res.values());

    }
    public class UnionFind{
        int[] parents;
        public  UnionFind(){
            parents=new int[10001];
            for(int i=0;i<10001;i++){
                parents[i]=i;
            }
        }
        public int find(int x){
            if(x!=parents[x]){
                parents[x]=find(parents[x]);
            }
            return parents[x];
        }
        public void union(int x,int y){
            int rootx=find(x);
            int rooty=find(y);
            if(rootx!=rooty){
                parents[rootx]=rooty;
            }
        }
    }
}