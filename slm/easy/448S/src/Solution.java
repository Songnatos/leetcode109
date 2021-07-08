import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int[] temp=new int[n+1];
        int min=n;int max=0;
        for(int i=0;i<n;i++){
            temp[nums[i]]=1;
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        for(int i=min;i<max;i++){
            if(temp[i]==0){
                res.add(temp[i]);
            }
        }
        return res;
    }
}