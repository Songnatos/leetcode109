class Solution {
    public int minCharacters(String a, String b) {
        int[] ac=new int[26];
        int[] bc=new int[26];
        for(char c:a.toCharArray()){
            ac[c-'a']++;
        }
        for(char c:b.toCharArray()){
            bc[c-'a']++;
        }
        int ans=a.length()+b.length();
        for(int i=0;i<26;i++){
            ans=Math.min(ans,a.length()+b.length()-ac[i]-bc[i]);
        }
        return Math.min(ans,Math.min(smaller(ac,bc),smaller(bc,ac)));

    }
    public int smaller(int[] a,int[] b){
        int res=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            int total=0;//记录要修改个数
            for(int j=i+1;j<26;j++){//比这个数大的都记录下来
                total+=a[j];
            }
            for(int j=0;j<=i;j++){
                total+=b[j];
            }
            res=Math.min(res,total);
        }
        return res;
    }
}