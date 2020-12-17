class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        String min="";
        int minlength=999;
        for(int i=0;i<strs.length;i++){
            if(strs[i].length()<minlength){
                min=strs[i];
                minlength=strs[i].length();
            }
        }
        for(int i=minlength;i>0;i--){
            String temp=min.substring(0,i);
            int count=0;
            for(int j=0;j<strs.length;j++){
                if(strs[j].contains(temp)&&strs[j].startsWith(temp)){
                    count++;
                    if(count==strs.length){
                        return temp;
                    }
                }
            }
        }
        return "";

    }
}