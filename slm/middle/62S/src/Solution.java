class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==m-1||j==n-1){
                    res[i][j]=1;
                }else{
                    res[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                res[i][j]=res[i+1][j]+res[i][j+1];
            }
        }
        return res[0][0];
    }
}