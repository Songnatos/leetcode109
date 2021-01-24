class Solution {
    public String maximumTime(String time) {
    char[] tarr=time.toCharArray();
        if (tarr[4] == '?') {
            tarr[4]='9';
        }
        if (tarr[3] == '?') {
            tarr[3]='5';
        }
        if(tarr[1]== '4'){
            if(tarr[3]!=0||tarr[4]!=0){
                if(tarr[0]=='?'){
                    tarr[0]='1';
                }
            }else{
                if(tarr[0]=='?'){
                    tarr[0]='2';
                }
            }
        }
        if(tarr[1]=='?'&&tarr[0]=='?'){
            if(tarr[3]!=0||tarr[4]!=0){
                tarr[1]='3';tarr[0]='2';
            }else{
                tarr[1]='4';tarr[0]='2';
            }
        }
        if(tarr[1]=='?'){
            if(tarr[0]=='2'){
                if(tarr[3]!=0||tarr[4]!=0){
                    tarr[1]='3';
                }else{
                    tarr[1]='4';
                }
            }else{
                tarr[1]='9';
            }
        }
        if(tarr[0]=='?'){
            if(tarr[1]>'3'){
                tarr[0]='1';
            }else{
                tarr[0]='2';
            }
        }

        StringBuilder res=new StringBuilder();
        for(char c:tarr){
            res.append(c);
        }
        return res.toString();
    }
}