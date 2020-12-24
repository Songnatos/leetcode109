class Solution {
    public int candy(int[] ratings) {
        int[] box = new int[ratings.length];
        box[0] = 1;
        for (int i = 1; i < box.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                box[i] = box[i-1] + 1;
            } else {
                box[i] = 1;
            }
        }

        int count = 0;
        int res = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                count ++;
            } else {
                count = 1;
            }
            res += Math.max(box[i], count);
        }
        return res;
    }
}