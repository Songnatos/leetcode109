import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> StoT=new HashMap<>();//存放s到t的对应关系
        Map<Character,Character> TtoS=new HashMap<>();
        for(int i=0;i<s.length();i++){
            Character temps=s.charAt(i);
            Character tempt=t.charAt(i);
            if((StoT.containsKey(temps)&&StoT.get(temps)!=tempt)||(TtoS.containsKey(tempt)&&TtoS.get(tempt)!=temps)){
                return false;
            }
            StoT.put(temps,tempt);
            TtoS.put(tempt,temps);

        }return true;

    }
}