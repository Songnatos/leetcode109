class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    int res=0;
    int max=0;
    int n=customers.length;
    for(int i=0;i<=n-X;i++){
        int temp=0;
        for(int j=i;j<i+X;j++){
            if(grumpy[j]==1){
                temp+=customers[j];
            }
        }
        max=Math.max(max,temp);
    }
    for(int i=0;i<n;i++){
        if(grumpy[i]==0){
           res+=customers[i];
        }
    }
    return res+max;
    }
}