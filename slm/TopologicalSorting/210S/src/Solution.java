import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {//广度优先遍历
    List<List<Integer>> edges;//代表指向这个点的值管理
    int[] indeg;//表示入度

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        edges = new ArrayList<List<Integer>>();
        indeg=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        int visited=0;
        for(int[] temp :prerequisites){
            edges.get(temp[1]).add(temp[0]);
            indeg[temp[0]]++;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int u=queue.poll();
            res[visited]=u;
            visited++;
            for(Integer temp: edges.get(u)){
                --indeg[temp];
                if(indeg[temp]==0){
                    queue.offer(temp);
                }
            }
        }
        return visited==numCourses?res:new int[0];
    }
}