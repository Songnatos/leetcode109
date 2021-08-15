import javax.sound.midi.Soundbank;
import java.util.*;

class Solution {
    private Deque<Integer> queue;
    private Map<Integer, Integer> map;
    private int capacity;

    private LinkedHashMap linkedHashMap = new LinkedHashMap();

    public Solution() {

    }

    public Solution(int capacity) {
         queue = new LinkedList<>();
         map = new HashMap();
         this.capacity = capacity;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {

        } else {
            if (queue.size()< capacity) {

            } else {

            }
        }
    }
}
