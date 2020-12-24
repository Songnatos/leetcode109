class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] res=new boolean[arr.length];
        return DFS(start,res,arr);


    }
    public boolean DFS(int index,boolean[] res,int[] arr){
        if(res[index]){
            return false;
        }
        res[index]=true;

        return DFS(index+arr[index],res,arr)||DFS(index+arr[index],res,arr);
    }
}