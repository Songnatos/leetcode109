class Solution {
    public int[] countBits(int num) {
    int[] res=new int[num+1];
    int level=0;
    res[0]=0;res[1]=1;
    for(int i=2;i<num+1;i++){
        if(i%Math.pow(2,level)==0){
            level++;
            res[i]=1;
        }else{
            res[i]=res[(int) (i-Math.pow(2,level))]+1;
        }
    }
    return res;
    }
}