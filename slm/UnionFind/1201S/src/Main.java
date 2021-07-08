import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> a= Arrays.asList(0,3);
        List<Integer> b= Arrays.asList(1,2);
        List<List<Integer>> arr=new ArrayList<>();
        arr.add(a);arr.add(b);
        solution.smallestStringWithSwaps("dcab", arr);
        System.out.println("Hello World!");
    }
}
