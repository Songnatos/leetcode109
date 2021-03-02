import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=speed.length;
        Car[] cars=new Car[n];
        for(int i=0;i<n;i++){
            cars[i]=new Car(position[i], (double)(target-position[i])/speed[i]);
        }
        Arrays.sort(cars,(a,b)->Integer.compare(a.pos,b.pos));
        int res=0;int t=n;
        while(--t>0){
            if(cars[t].time<cars[t-1].time) res++;
            else cars[t-1]=cars[t];
        }
        return res+(t==0?1:0);
    }
    class  Car{
        int pos;
        double  time;
        public Car(int pos,double time){
            this.pos=pos;
            this.time=time;
        }
    }
}