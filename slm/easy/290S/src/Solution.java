import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        if(pattern.length()>s.split(" ").length)
            return false;
        for(int i=0;i<pattern.length();i++){
            if(res.length()!=0){
                res.append(" ");
            }
            if(!map.containsKey(pattern.charAt(i))){
                for(Character temp:map.keySet()){
                    if(map.get(temp).equals(s.split(" ")[i])){
                        return false;
                    }
                }
                map.put(pattern.charAt(i),s.split(" ")[i]);
                res.append(s.split(" ")[i]);
            }else{
                res.append(map.get(pattern.charAt(i)));
            }
        }
        return res.toString().equals(s);
    }
}