package dailycode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Canyon
 */
public class FindWordsContaining2942 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            char[] ch = words[i].toCharArray();
            for (char c : ch) {
                if (c == x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}
