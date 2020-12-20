class Solution {
    public String reformatNumber(String number) {
        number=number.replaceAll(" ","").replaceAll("-","");
        StringBuilder res=new StringBuilder();
        if(number.length()%3==1){
            for(int i=0;i<number.length()-4;i++){
                res.append(number.charAt(i));
                if((i+1)%3==0&&(i!=number.length()-1)){
                    res.append("-");
                }
            }
            res.append(number.charAt(number.length()-4));
            res.append(number.charAt(number.length()-3));
            res.append("-");
            res.append(number.charAt(number.length()-2));
            res.append(number.charAt(number.length()-1));
        }else{
            for(int i=0;i<number.length();i++){
                res.append(number.charAt(i));
                if((i+1)%3==0&&(i!=number.length()-1)){
                    res.append("-");
                }
            }
        }

        return res.toString();
    }
}