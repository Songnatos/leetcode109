import java.util.Arrays;

class Solution {
    public boolean check(int[] position, int m, int length) {
        int count = 1;
        int pre = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= length) {
                pre = position[i];
                count++;
            }
        }
        return count >= m;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int ans = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (check(position, m, mid) == true) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}