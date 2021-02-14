class Solution {
    int[] temp=new int[1000];
    public int countHomogenous(String s) {
        for(int i=1;i<100;i++){
            temp[i]=f(i);
        }
    char[] ss=s.toCharArray();
        int count=0;
        char tempc=ss[0];
        int num=0;
    for(int i=1;i<s.length();i++){
        if(ss[i]==tempc){
            num++;
        }else{
            tempc=ss[i];
            count=count+temp[num+1];
            count=count%1000000007;
            num=0;
        }
    }
    return count+temp[num+1];
    }
    public int f(int n){
    if(n==1||n==0){
        return 1;
    }else{
        return temp[n-1]+n;
    }
    }
}