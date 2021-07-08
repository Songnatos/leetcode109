import java.util.List;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    int res=0;
    int checknum=-1;
    if(ruleKey.equals("type")){
        checknum=0;
    }else if(ruleKey.equals("color")){
        checknum=1;
    }else{
        checknum=2;
    }
    for(List<String> item:items){
        if(ruleValue.equals(item.get(checknum))){
            res++;
        }
    }
    return res;
    }
}