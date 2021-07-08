class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res=new int[2];
        int suma=0;int sumb=0;
        for(int i=0;i<A.length;i++){
            suma+=A[i];
        }
        for(int i=0;i<B.length;i++) {
            sumb += B[i];
        }
            for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                res[0]=A[i];
                res[1]=B[i];
                if((suma-res[0]+res[1])==(sumb-res[1]+res[0])){
                    return res;
                }
            }
        }
        return new int[2];

    }
}