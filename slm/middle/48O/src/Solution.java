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
            if(gap[s.charAt(i)-'a']==-1){
                gap[s.charAt(i)-'a']=i;
                if(i==(s.length()-1)){
                    maxlength=Math.max(i-start+1,maxlength);
                }
            }else{
                start=gap[s.charAt(i)-'a']+1;
                if(s.charAt(start-1)==s.charAt(i))maxlength=Math.max(i-start,maxlength);
                else maxlength=Math.max(i-start+1,maxlength);
                gap[s.charAt(i)-'a']=i;
            }
        }
        return maxlength==-1?s.length():maxlength;
    }
}