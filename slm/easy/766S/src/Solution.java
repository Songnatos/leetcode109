class Solution {
    int[][] mat;
    public boolean isToeplitzMatrix(int[][] matrix) {
        mat=matrix;
    int m=matrix.length;
    int n=matrix[0].length;
    for(int i=0;i<m;i++){
        if(!check(0,i)){
            return false;
        }
    }
    for(int i=0;i<n;i++){
            if(!check(i,0)){
                return false;
            }
        }

    return true;
    }
    public boolean check(int i,int j){
        int temp=mat[i][j];
        while(i<mat.length&&j<mat[0].length){
            if(mat[i][j]!=temp){
                return false;
            }else{
                i++;j++;
            }
        }
        return true;
    }
}