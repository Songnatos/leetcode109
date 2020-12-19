class Solution {
    public double myPow(double x, int n) {
        long b=n;//防止越界
        if(b<0){
            b=-b;
            x=1/x;
        }
        double res=1;
       while(b!=0){
           if(b%2==1){
               res=res*x;
           }
           x=x*x;
           b=b/2;
       }
       return res;
    }

}