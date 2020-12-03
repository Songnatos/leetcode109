class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int x = 0, y = k;
        while (y >= 0) {
            if (x > nums1.length || y > nums2.length) {
                x++;
                y--;
                continue;
            }
            int[] seq1 = findMaxSeq(nums1, x);
            int[] seq2 = findMaxSeq(nums2, y);
            int[] newRes;
            if (seq1 == null) {
                newRes = seq2;
            } else if (seq2 == null) {
                newRes = seq1;
            } else {
                newRes = parseRes(seq1, seq2);
            }
            res = isNewBigger(res, newRes) ? newRes : res;

            x++;
            y--;
        }

        return res;
    }

    private int[] findMaxSeq(int[] nums, int n) {
        if (n == 0)
            return null;
        int length = nums.length;
        int[] stack = new int[n];
        int top = -1;
        int remain = length - n;
        for (int num : nums) {
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < n - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    private int[] parseRes(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] res = new int[n];
        for (int k = 0, i = 0, j = 0; k < n; k++) {
            if (isFrontBigger(nums1, i, nums2, j)) {
                res[k] = nums1[i++];
            } else {
                res[k] = nums2[j++];
            }
        }
        return res;
    }

    private boolean isNewBigger(int[] oldRes, int[] newRes) {
        for (int i = 0; i < oldRes.length; i++) {
            if (newRes[i] > oldRes[i])
                return true;
            else if (newRes[i] < oldRes[i])
                return false;
        }
        return false;
    }

    private boolean isFrontBigger(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] != nums2[j])
                return nums1[i] - nums2[j] > 0;
            i++;
            j++;
        }
        return (nums1.length - i) - (nums2.length - j) > 0;
    }
}
