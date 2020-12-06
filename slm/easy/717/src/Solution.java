class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        while(i<bits.length){
            if(bits[i]==0){
                i++;
            }else{
                i+=2;
            }
        }
        if(i==bits.length-1){
            return true;
        }else{
            return false;
        }
    }
}