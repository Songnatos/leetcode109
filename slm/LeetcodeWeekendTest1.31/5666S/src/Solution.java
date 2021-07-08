//class Solution {
//    public boolean[] canEat(int[] candiesCount, int[][] queries) {
//        int n=queries.length;
//        boolean[] res=new boolean[n];
//        for(int i=0;i<n;i++){
//            res[i]=Judge(candiesCount,queries[i]);
//        }
//        return res;
//    }
//    public boolean Judge(int[] candiesCount, int[] queries){
//        Long n= new Long(queries[2]);//每天最多几个
//        Long d=new Long(queries[1]);//天数
//        int t=queries[0];
//        Long count=new Long(0);//需要吃完多少
//        for(int i=0;i<t;i++){
//            count+=candiesCount[i];
//        }
//
//        if(count+candiesCount[t]<d||count>n*d){
//            return false;
//        }
//        return true;
//    }
//}
//class Solution {
//
//    public boolean[] canEat(int[] candiesCount, int[][] queries) {
//        long[] sum = new long[candiesCount.length];
//        for (int i = 0; i < sum.length; i++) {
//            sum[i] = candiesCount[i] + (i > 0 ? sum[i - 1] : 0);
//        }
//        boolean[] result = new boolean[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            result[i] = sum[queries[i][0]] > queries[i][1]
//                    && (queries[i][0] == 0 || sum[queries[i][0] - 1] < 1L * (queries[i][1] + 1) * queries[i][2]);
//        }
//        return result;
//    }
//}
class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long sum = 0;
        long[] sums = new long[n];
        for (int i = 0; i < n; i++) {
            sum += candiesCount[i];
            sums[i] = sum;
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int left = bs(q[1] + 1, sums), right = bs(((long)q[2]) * (q[1] + 1), sums);
            if (q[0] >= left && q[0] <= right) {
                res[i] = true;
            }
        }

        return res;
    }

    private int bs(long val, long[] sums) {
        int s = 0, e = sums.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (sums[mid] >= val) e = mid - 1;
            else s = mid + 1;
        }

        return s;
    }
}