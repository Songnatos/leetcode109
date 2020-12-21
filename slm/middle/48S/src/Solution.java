class Solution {
    public void rotate(int[][] matrix) {
    for(int i=0;i<matrix.length;i++){
        for(int j=0;j<i;j++){
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }

        for(int i=0;i<matrix.length/2+1;i++){
            for(int j=0;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[matrix.length-i][j];
                matrix[matrix.length-i][j]=temp;
            }
        }
    }
}