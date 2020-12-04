

class Solution {
    public int[] subMaxNumber(int[] nums, int len) {//求len长度数组最大情况（单调栈思想）在允许情况下栈内从大到小 remain也考虑了不允许情况
        int cur=0;
        int remain=nums.length-len;
        int[] res=new int[len];
        for(int i=0;i<nums.length;i++){
            while(cur>0&&res[cur-1]<nums[i]&&remain>0){//remain表示还有多少可以删除的
                cur--;
                remain--;
            }
            if(cur<len){
                res[cur++]=nums[i];
            }else{
                remain--;//表示当前数组这个值小于 不许入栈 但剩余可删除的数字减一
            }
        }
        return res;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    int[] res=new int[0];
        for(int i=0;i<=nums1.length&&i<=k;i++){
            if (k - i >= 0 && k - i <= nums2.length) {
                int[] tmp = merge(subMaxNumber(nums1, i), subMaxNumber(nums2, k - i));
                // 取最大值
                if (compare(tmp, 0, res, 0)) {
                    res = tmp;

            }
        }

    }
        return  res;
    }
    public int[] merge(int[] nums1, int[] nums2) {//合并两个数组，合并时也要比较
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0, cur1 = 0, cur2 = 0;
        while (cur < nums1.length + nums2.length) {
            if (compare(nums1, cur1, nums2, cur2)) {
                res[cur++] = nums1[cur1++];
            } else {
                res[cur++] = nums2[cur2++];
            }}
            return res;
        }

    public
    boolean compare(int[] nums1, int p1, int[] nums2, int p2) {//比较两个数组大小
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }

}