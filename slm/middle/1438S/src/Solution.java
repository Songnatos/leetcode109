import java.util.ArrayDeque;
import java.util.Deque;

class Solution
{
    public int longestSubarray(int[] nums, int limit)
    {
        int n=nums.length;
        Deque<Integer> minDeque=new ArrayDeque<>();
        Deque<Integer> maxDeque=new ArrayDeque<>();
        minDeque.add(0);
        maxDeque.add(0);

        int left=0, right=1, ans=1;
        while(right<n)
        {
            //维护单调递增队列，队首元素为滑动窗口中最小元素最后一次出现的位置下标
            while(!minDeque.isEmpty() && nums[right]<nums[minDeque.getLast()])
                minDeque.removeLast();
            minDeque.add(right);

            //维护单调递减队列，队首元素为滑动窗口中最大元素最后一次出现的位置下标
            while(!maxDeque.isEmpty() && nums[right]>nums[maxDeque.getLast()])
                maxDeque.removeLast();
            maxDeque.add(right);

            //新的元素加入后，判断此时滑动窗口中的最大差值是否还满足条件
            while(Math.abs(nums[maxDeque.element()]-nums[minDeque.element()])>limit)
            {
                //若不满足，则一定是新加入的元素替换了原来的最大值或者最小值

                //若替换的是最大值，则此时滑动窗口的左边界应该移动到原先最小值位置的下一位，以此来减小滑动窗口内的最大差值
                if(right==maxDeque.element())
                    left=minDeque.removeFirst()+1;

                    //若替换的是最小值，同理
                else if(right==minDeque.element())
                    left=maxDeque.removeFirst()+1;
            }

            ans=Math.max(ans, right-left+1);

            right++;
        }

        return ans;
    }
}