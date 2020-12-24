import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res=0;
        int i=s.length-1;int j=g.length-1;
        while(i!=-1&&j!=-1){
            while(g[j]>s[i]&&j!=0){
                j--;
            }
            if(g[j]>s[i]){
                res--;
            }
            res++;
            i--;j--;
        }
        return res;
    }
}