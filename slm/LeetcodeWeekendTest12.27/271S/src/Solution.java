class Solution {
    public boolean halvesAreAliake(String s) {
    String yuan="aeiouAEIOU";
    char[] ss=s.toCharArray();
    int count=0;
    for(int i=0;i<s.length()/2;i++){
        StringBuilder temp=new StringBuilder();
        temp.append(ss[i]);
        if(yuan.indexOf(temp.toString())>=0){
            count++;
        }
    }
        for(int i=s.length()/2;i<s.length();i++){
            StringBuilder temp=new StringBuilder();
            temp.append(ss[i]);
            if(yuan.indexOf(temp.toString())>=0){
                count--;
            }
        }
        if(count==0){
            return true;
        }else{
            return false;
        }
    }

}