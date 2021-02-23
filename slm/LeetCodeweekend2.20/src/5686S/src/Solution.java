class Solution {
    public int[] minOperations(String boxes) {
        char[] box=boxes.toCharArray();
        int n=box.length;
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=count(i,box);
        }
        return res;

    }
    public  int count(int i,char[] box){
        int res=0;
        for(int j=0;j<box.length;j++){
            if(box[j]=='1')
            res+=Math.abs(i-j);
        }
        return res;
    }
}