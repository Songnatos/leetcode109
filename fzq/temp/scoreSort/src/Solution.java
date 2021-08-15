import java.util.*;

class Solution {

    public void find(Integer[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> o2 - o1);
    }


    public Map<String, Algorithm> gen(Map<String, String[]> algorithmStrs) {
        Map<String, Algorithm> algorithms = new HashMap<>();
        for (Map.Entry<String, String[]> entry : algorithmStrs.entrySet()) {
            String className = entry.getValue()[0];
            try {
                Class clazz = Class.forName(className);
                Algorithm algorithm = (Algorithm) clazz.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

        return algorithms;
    }


    public List<Map<String, Object>> socoreSort(List<Map<String, Object>> records, Map<String, Algorithm> algorithms) {
        for (Map<String, Object> record : records) {
            int finalScore = 0;
            for (Map.Entry<String, Algorithm> entry: algorithms.entrySet()) {
                Double value = (Double) record.get(entry.getKey());
                Algorithm algorithm = entry.getValue();
                Double score = algorithm.calcScore(value);
                record.put(entry.getKey()+"-score", score);
                finalScore += score * algorithm.getWeight();
            }
            record.put("finalScore", finalScore);
        }
        records.sort(Comparator.comparing(o -> (Double.valueOf(o.get("finalScore").toString()))));
        return records;
    }
}
