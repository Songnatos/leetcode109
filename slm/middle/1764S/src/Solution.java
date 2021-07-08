class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
    int n=groups.length;int m=nums.length;
    int res=0;
    for(int i=0,j=0;i<n&&j<m;){
        if(check(groups[i],nums,j)){
            j+=groups[i++].length;
            res++;
        }else{
            j++;
        }

    }
    return res==n;
    }
    public boolean check(int[] g,int[] nums,int i){
        int j=0;
        for(;j<g.length&&i<nums.length;i++,j++){
            if(g[j]!=nums[i]){
                return false;
            }
        }
        return j==g.length;
    }
}