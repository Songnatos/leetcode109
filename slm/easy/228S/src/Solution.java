import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
    int n=nums.length;
    List<String> res=new ArrayList<>();
    int start=0;
    int end=0;
    for(int i=1;i<n;i++){
        if(nums[i]!=nums[i-1]+1){
            end=i-1;
            if(start!=end){
                res.add(nums[start]+"->"+nums[end]);
            }else{
                res.add(String.valueOf(nums[start]));
            }

            start=i;
        }
    }
        if(start!=n-1){
            res.add(nums[start]+"->"+nums[n-1]);
        }else{
            res.add(String.valueOf(nums[n-1]));
        }
    return res;
    }
}