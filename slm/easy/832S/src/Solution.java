class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
    int n=A.length;
    int m=A[0].length;
    for(int i=0;i<n;i++){
        for(int j=0;j<m/2;j++){
            int temp=A[i][j];
            A[i][j]=A[i][m-j-1];
            A[i][m-j-1]=temp;
        }
        for(int j=0;j<m;j++){
            A[i][j]=1-A[i][j];
        }
    }
    return A;
    }
}