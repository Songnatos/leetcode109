class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res=0;
        for(int i=1;i<points.length;i++){
            int[] distance=new int[2];
            distance[0]=points[i][0]-points[i-1][0];
            distance[1]=points[i][1]-points[i-1][1];
            while(distance[0]!=0&&distance[1]!=0){
                if(distance[0]*distance[1]>0){
                    if(distance[0]>0){
                        distance[0]--;
                        distance[1]--;
                    }else{
                        distance[0]++;
                        distance[1]++;
                    }
                }else{
                    if(distance[0]>0){
                        distance[0]--;
                        distance[1]++;
                    }else{
                        distance[0]++;
                        distance[1]--;
                    }
                }
                res++;
            }
            res=res+Math.abs( distance[0])+Math.abs( distance[1]);
        }
        return res;
    }
}