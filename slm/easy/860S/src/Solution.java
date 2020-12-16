class Solution {
    public boolean lemonadeChange(int[] bills) {
            int count5=0;
            int count10=0;
            for(int i=0;i<bills.length;i++){
                if(bills[i]==5){
                    count5++;
                }else if(bills[i]==10){
                    count10++;
                    count5--;
                    if(count5<0)return  false;
                }else{
                    if(count10<=0){
                        count5-=3;
                    }else{
                        count10--;
                        count5--;
                    }
                    if(count5<0||count10<0){return false;}
                }
            }
            return true;
    }
}