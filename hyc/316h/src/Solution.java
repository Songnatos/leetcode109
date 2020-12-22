import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        List<Character> stack = new ArrayList<>();
        boolean[] exist = new boolean[26];
        char[] chArray = s.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            map[chArray[i] - 'a'] ++;
        }
        for (int i = 0; i < chArray.length; i++) {
            if (exist[chArray[i] - 'a'] == false) {
                while (stack.size() > 0) {
                    Character temp = stack.get(stack.size() - 1);
                    if (map[temp - 'a'] > 0 && temp > chArray[i]) {
                        exist[stack.remove(stack.size() - 1) - 'a'] = false;
                    } else {
                        break;
                    }
                }
                stack.add(chArray[i]);
                exist[chArray[i] - 'a'] = true;
            }
            map[chArray[i] - 'a'] --;
        }
        String res = "";
        for (Iterator<Character> it = stack.iterator(); it.hasNext(); ) {
            Character ch = it.next();
            res += ch;
        }
        return res;
    }
}