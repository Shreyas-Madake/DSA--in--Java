package SDE_sheet;
import java.util.*;

public class Q32_Count_and_say {
    public String countAndSay(int n) {
        // 1. Base case FIRST
        if (n == 1) return "1";

        // 2. Recursive call AFTER base case check
        String res = countAndSay(n - 1);

        int count = 1;
        char currchar = res.charAt(0); // Changed to char
        StringBuilder str = new StringBuilder();// we are using StringBuilder to avoid creating multiple string objects in memory, which is more efficient.

        // 3. Run-length encoding loop
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) == currchar) {
                count++;
            } else {
                str.append(count).append(currchar);
                // we are resetting the count and updating the current character for the next group so that we can correctly count the occurrences of the next character in the string.
                count = 1;
                currchar = res.charAt(i);
            }
        }

        // Append the last group
        str.append(count).append(currchar);

        return str.toString();
    }
}