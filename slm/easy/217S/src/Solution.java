import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsDuplicate(int[] nums) {
    Map<Integer,Integer> res=new HashMap<>();
    for(int i=0;i<nums.length;i++){
        if(res.containsKey(nums[i])){
            return  false;
        }else{
            res.put(nums[i],nums[i]);
        }
    }
    return true;
    }
}