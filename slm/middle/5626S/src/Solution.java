class Solution {
    public int minPartitions(String n) {
        char[] s=n.toCharArray();
        char max='0';
        for(int i=0;i<s.length;i++){
            if(s[i]>max){
                max=s[i];
            }
        }
        return Integer.valueOf(String.valueOf(max));
    }
}