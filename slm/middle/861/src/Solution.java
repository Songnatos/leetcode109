class Solution {
    public int matrixScore(int[][] A) {
        boolean flag=true;
        int res=0;
        for(int i=0;i<A.length;i++){
            if(A[i][0]==0){
                flag=false;
            }else{
                flag=true;
            }
            for(int j=0;j<A[i].length;j++){
                if(!flag)
                A[i][j]=(A[i][j]+1)%2;
            }
        }
        int count=0;
        for(int i=A[0].length-1;i>=0;i--){
            count=0;
                for(int j=0;j<A.length;j++){
                    if(A[j][i]==1)count++;
                }
                res=res+Math.max(A.length-count,count)*(int)Math.pow(2,A[0].length-1-i);
        }
        return res;

    }
}