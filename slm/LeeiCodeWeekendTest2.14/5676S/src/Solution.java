class Solution {
    public int minOperations(String s) {
    int res0=0;
    int res1=0;
    int n=s.length();
    StringBuilder s1=new StringBuilder();
    StringBuilder s2=new StringBuilder();
    for(int i=0;i<n;i++){
        if(i%2==0){
            s1.append(1);
            s2.append(0);
        }else{
            s1.append(0);
            s2.append(1);
        }
    }
    char[] temps=s.toCharArray();
    char[] temp1=s1.toString().toCharArray();
    char[] temp2=s2.toString().toCharArray();
    for(int i=0;i<n;i++){
        if(temps[i]!=temp1[i]){
            res0++;
        }
        if(temps[i]!=temp2[i]){
            res1++;
        }
    }
    return  Math.min(res0,res1);
    }
}