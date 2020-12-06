class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] res=new int[matrix.length][];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    res[i][j]=Integer.MAX_VALUE-1;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                 res[i][j]=matrix[i][j];

                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0){

                    }else if(i==matrix.length)
                    res[i][j]=matrix[i][j];//四周最大值

                }
            }
        }
        return res;
    }
}