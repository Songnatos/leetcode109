import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Map<String, Object>> records = new ArrayList<>();
        Map<String, Object> o1 = new HashMap<>();
        Map<String, Object> o2 = new HashMap<>();
        Map<String, Object> o3 = new HashMap<>();

        o1.put("a", 1); o1.put("b", 13);
        o2.put("a", 2); o2.put("b", 12);
        o3.put("a", 3); o3.put("b", 11);

        records.add(o2);
        records.add(o1);
        records.add(o3);

        System.out.println(records);

        records.sort(Comparator.comparing(o -> (Double.valueOf(o.get("a").toString()))));





        System.out.println(records);

        System.out.println("Hello World!");
    }
}
