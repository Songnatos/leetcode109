import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res=new ArrayList<>();
        backtracking(S,0,res);
        return res;
    }
    public boolean IsFibonacci(Integer num, List<Integer> ans){//判断是否满足要求
        Integer size=ans.size();
        if(size<2)return true;
        return (ans.get(size-2)+ans.get(size-1)==num);
    }

    private boolean backtracking(String S, int start, List<Integer> ans) {
        if(start==S.length()&&ans.size()>2){
            return true;
        }
        for(int i=start;i<S.length();i++){
            String segment=S.substring(start,i+1);
            if(Long.parseLong(segment)>Long.MAX_VALUE)break;
            if(!"0".equals(segment)&&segment.startsWith("0"))break;
            if(IsFibonacci(Integer.parseInt(segment),ans)){
                ans.add(Integer.valueOf(segment));
                if(backtracking(S,i+1,ans)) return true;
                ans.remove(ans.size()-1);
            }
        }

        return false;
    }
}