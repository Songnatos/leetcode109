class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<3){
            return true;
        }
        if(coordinates[1][0]==coordinates[0][0]){
            boolean flag=true;
            for(int i=0;i<coordinates.length;i++){
                if(coordinates[i][0]!=coordinates[0][0]){
                    flag=false;
                }
            }
            return  flag;
        }
        double k=(coordinates[1][1]-coordinates[0][1])/((double)coordinates[1][0]-coordinates[0][0]);
        double b=coordinates[0][1]-k*(double)coordinates[0][0];
        for(int[] coor:coordinates){
            if((k*coor[0]+b)!=coor[1]){
                return false;
            }
        }
        return true;
    }
}