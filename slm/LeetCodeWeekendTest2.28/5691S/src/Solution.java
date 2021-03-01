import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n1 =nums1.length;
        int n2=nums2.length;
        int[] count=new int[7];
        int total=0;
        int res=0;
        if(n1>6*n2||n2>6*n1){
            return -1;
        }
        for(int i=0;i<n1;i++){
            count[nums1[i]]++;
            total+=nums1[i];
        }
        for(int i=0;i<n2;i++){
            count[7-nums2[i]]++;
            total-=nums2[i];
        }
        if(total<0){
            total=Math.abs(total);
            for(int i=1;i<6;i++){
                if(count[i]*(6-i)>=total) return res+(total+6-i-1)/(6-i);
                total-=count[i]*(6-i);
                res+=count[i];
            }
        }else{
            for(int i=6;i>0;i--){
                if(count[i]*(i-1)>=total) return res+(total+i-2)/(i-1);
                total-=count[i]*(i-1);
                res+=count[i];
            }
        }

        return res;
    }
}