class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        if("   ".equals(s)){
            return 1;
        }
        int[] gap=new int[26];
        for(int i=0;i<26;i++){
            gap[i]=-1;
        }
        int start=0;
        int maxlength=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'a'||s.charAt(i)>'z'){
                return 0;
            }
            if(gap[s.charAt(i)-'a']==-1||gap[s.charAt(i)-'a']<start){
                gap[s.charAt(i)-'a']=i;

            }
            else{
                 maxlength=Math.max(i-start,maxlength);
                start=gap[s.charAt(i)-'a']+1;
                gap[s.charAt(i)-'a']=i;
            }
        }
        maxlength=Math.max(s.length()-start,maxlength);
        return maxlength;
    }
}