import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3,4,8,9,3,0};
        int[] nums2 = {6,1,9,1,1,2};
        int k = 6;
        System.out.println(Arrays.toString(solution.maxNumber(nums1, nums2, k)));
    }
}