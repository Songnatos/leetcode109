import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a={3,4,8,9,3,0};
        int[] b={6,1,9,1,1,2};
        int k=6;
        int[] res=solution.maxNumber(a,b,k);
        System.out.println(Arrays.toString(res));
        System.out.println("Hello World!");
    }
}
