class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res=new StringBuilder();
        int ca=0;int sum=0;
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
            sum=ca;
            int aa=(i>=0?a.charAt(i)-'0':0);
            int bb=(j>=0?b.charAt(j)-'0':0);
            sum=sum+aa+bb;
            res.append(sum%2);
            ca=sum/2;
        }
        res.append(ca==1?"1":"");
        return  String.valueOf(res.reverse());
    }

//    class Solution {
//        public String addBinary(String a, String b) {
//            return Integer.toBinaryString(
//                    Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
//            );
//        }
//    }

}