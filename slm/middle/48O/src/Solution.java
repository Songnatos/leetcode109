class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
       int[] gap=new int[1000];
       for(int i=0;i<1000;i++){
           gap[i]=-1;
       }
       int start=0;
       int maxlength=-1;
       for(int i=0;i<s.length();i++){
           if(gap[s.charAt(i)-' ']!=-1||gap[s.charAt(i)-' ']<start){
               gap[s.charAt(i)-' ']=i;
           }else{
               maxlength=Math.max(i-start,maxlength);
               start=gap[s.charAt(i)-' ']+1;
               gap[s.charAt(i)-' ']=i;
           }
       }
        maxlength=Math.max(s.length()-start,maxlength);
       return maxlength;

    }
}
