import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        Arrays.sort(nums);
        if (nums[0] != 0) return set.size() >= 5 && nums[4] - nums[0] < 5;
        else if (nums[1] != 0) return set.size() >= 5 && nums[4] - nums[1] < 5;
        else if (nums[2] != 0) return set.size() >= 4 && nums[4] - nums[2] < 5;
        else if (nums[3] != 0) return set.size() >= 3 && nums[4] - nums[3] < 5;
        else return true;
    }


//    public boolean isStraight(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) set.add(num);
//        if (set.size() <= 3) return false;
//        Arrays.sort(nums);
//        if (nums[0] != 0) return set.size() >= 5 && nums[4] - nums[0] <= 5;
//        else if (nums[1] != 0) return set.size() >= 5 && nums[4] - nums[1] <= 5;
//        else return set.size() >= 4 && nums[4] - nums[2] <= 5;
//    }
}
