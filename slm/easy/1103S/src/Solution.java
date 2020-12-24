class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        int can=1;
    while(candies!=0){
        for(int i=0;i<num_people;i++){
            int temp=candies-can>0?can:candies;
           res[i]+=temp;
           candies=candies-temp;
           can++;
        }
    }
    return res;
    }
}