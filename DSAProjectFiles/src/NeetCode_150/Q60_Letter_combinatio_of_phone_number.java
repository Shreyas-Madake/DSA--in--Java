package NeetCode_150;

import java.util.ArrayList;
import java.util.List;

public class Q60_Letter_combinatio_of_phone_number {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        return helper("", digits);
    }

    static List<String> helper(String p, String up){
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        List<String> list = new ArrayList<>();
        int digit = up.charAt(0) - '0';

        // digit 2=abc(0,1,2), 3=def(3,4,5)... but 7=pqrs(18,19,20,21), 9=wxyz(22,23,24,25)
        int start = (digit - 2) * 3;
        int end = start + 3;

        // 7,8,9 are shifted by 1 because of extra letter in 7(pqrs)
        if(digit >= 8) { start += 1; end = start + 3; }
        if(digit == 7) { end = start + 4; } // pqrs = 4 letters
        if(digit == 9) { end = start + 4; } // wxyz = 4 letters

        for(int i = start; i < end; i++){
            char ch = (char)('a' + i);
            list.addAll(helper(p + ch, up.substring(1)));
        }
        return list;
    }
}
