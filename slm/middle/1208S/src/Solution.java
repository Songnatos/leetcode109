class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] chars=s.toCharArray();
        char[] chart=t.toCharArray();
        int n=chars.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=Math.abs( chars[i]-chart[i]);
        }
        int max=0;
        for(int i=0;i<n;i++){
             int count=0;
             int tempcost=maxCost;
            for(int j=i;j<n;j++){
                if(tempcost-res[j]<0){
                    break;
                }else{
                    tempcost-=res[j];
                    count++;
                    max=Math.max(max,count);
                }
            }
        }
        return max;
    }
}