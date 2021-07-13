import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
    public char firstUniqChar(String s) {
        Deque<Character> deque = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (set.contains(c)) {
                deque.remove(c);
            } else {
                set.add(c);
                deque.offer(c);
            }
        }
        return deque.isEmpty() ? ' ' : deque.getFirst();
    }
}
