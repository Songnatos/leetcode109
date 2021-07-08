class Solution {
    public int balancedStringSplit(String s) {
        int count=0;
        int n=s.length();
        char[] temp=s.toCharArray();
        for(int i=1;i<n;i++){
            if(temp[i]!=temp[i-1]){
                count++;
            }
        }
        return count/2+1;
    }
}