class Solution {
    public String interpret(String command) {
        StringBuilder res=new StringBuilder(command);
        while(res.indexOf("(al)")!=-1){
            res.replace(res.indexOf("(al)"),res.indexOf("(al)")+4,"al");
        }
        while(res.indexOf("()")!=-1){
            res.replace(res.indexOf("()"),res.indexOf("()")+2,"o");
        }
        return res.toString();
    }
}