class Solution {
    /**
     * 可以二分加速
     */
    public int minArray(int[] numbers) {
        int p = numbers[0], q = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (p > numbers[i]) {
                q = numbers[i];
                break;
            }
            p = numbers[i];
        }
        return q;
    }

    public int minArray2(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }

}
