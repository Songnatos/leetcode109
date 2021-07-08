class Solution {
    public int characterReplacement(String s, int k) {
    int left=0;
    int right=0;
    int max=0;
    int n=s.length();
    int[] num=new int[26];
    while(right<n){
        num[s.charAt(right)-'A']++;
        max=Math.max(max, num[s.charAt(right)-'A']);
        if(right-left+1-max>k){
            num[s.charAt(left)-'A']--;
            left++;
        }
        right ++;
    }
    return right-left;
    }
}