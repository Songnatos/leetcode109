import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                radiant.offer(i);
            }else{
                dire.offer(i);
            }
        }
        while(!radiant.isEmpty()||!dire.isEmpty()){
            Integer Rindex=radiant.poll();Integer Dindex=dire.poll();
            if(Rindex<Dindex){
                radiant.offer(Rindex+senate.length());
            }else{
                dire.offer(Dindex+senate.length());
            }
        }
        if(radiant.isEmpty()){
            return "Dire";
        }else{
            return "Radiant";
        }

}}