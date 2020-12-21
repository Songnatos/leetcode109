class Solution {
    public int countVowelStrings(int n) {
        int[][] arr= new int[n+1][6];
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<6;j++){
                arr[i][j]=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=2;j<6;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        for(int j=1;j<6;j++){
            res+=arr[n-1][j];
        }
        return res;
    }
}