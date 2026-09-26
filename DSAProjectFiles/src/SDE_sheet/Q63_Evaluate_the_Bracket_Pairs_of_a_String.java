package SDE_sheet;

import java.util.HashMap;
import java.util.List;

public class Q63_Evaluate_the_Bracket_Pairs_of_a_String {
    public String evaluate(String s, List<List<String>> knowledge) {

        int n = s.length();

        HashMap<String, String> mp = new HashMap<>();

        for (List<String> vec : knowledge) {
            mp.put(vec.get(0), vec.get(1));
        }

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < n) {

            if (Character.isLetter(s.charAt(i))) {
                result.append(s.charAt(i));

            } else { // '('
                i++;

                StringBuilder temp = new StringBuilder();

                while (i < n && s.charAt(i) != ')') {
                    temp.append(s.charAt(i));
                    i++;
                }

                String key = temp.toString();

                if (mp.containsKey(key)) {
                    result.append(mp.get(key));
                } else {
                    result.append("?");
                }
            }

            i++;
        }

        return result.toString();
    }
}
