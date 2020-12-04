class Solution {
    public int countPrimes(int n) {
        boolean[] res=new boolean[n+1];
        for(int i=2;i<n;i++){
            res[i]=true;
        }
        for(int i=2;i*i<n;i++){
            if(!res[i])continue;
            for(int j=i*i;j<n;j=j+i){//保证全部覆盖到
                res[j]=false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (res[i]) count++;
        }
        return count;

    }

}