package SDE_sheet;

public class Q54_lexGreaterPermutatio_code_no_3720 {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        // Count characters of s
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int targetChar = target.charAt(i) - 'a';

            // ------------------------------------------------
            // OPTION 1:
            // Try to keep the same character as target[i]
            // ------------------------------------------------

            if (count[targetChar] > 0) {

                // Temporarily use target[i]
                count[targetChar]--;

                // Check whether the remaining characters
                // can make something greater than target suffix
                if (canMakeGreater(count, target, i + 1)) {

                    // Keeping target[i] is possible
                    result.append(target.charAt(i));

                    continue;
                }

                // Keeping this character does not work.
                // Put it back.
                count[targetChar]++;
            }

            // ------------------------------------------------
            // OPTION 2:
            // Choose the smallest character greater than target[i]
            // ------------------------------------------------

            for (int c = targetChar + 1; c < 26; c++) {

                if (count[c] > 0) {

                    // Put this slightly larger character
                    result.append((char) ('a' + c));

                    count[c]--;

                    // Put all remaining characters
                    // in ascending order
                    for (int k = 0; k < 26; k++) {

                        while (count[k] > 0) {
                            result.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return result.toString();
                }
            }

            // We cannot keep target[i]
            // and cannot choose anything larger.
            // Therefore this prefix is impossible.
            return "";
        }

        // target itself was the largest possible permutation
        return "";
    }

    private boolean canMakeGreater(
            int[] count,
            String target,
            int start
    ) {

        // Create the LARGEST possible string
        // from the remaining characters.
        //
        // If even this largest string
        // is NOT greater than target's suffix,
        // then no arrangement can work.

        StringBuilder largest = new StringBuilder();

        for (int c = 25; c >= 0; c--) {

            while (count[c] > 0) {
                largest.append((char) ('a' + c));
                count[c]--;
            }
        }

        // Restore count because this was only a check
        for (int i = 0; i < largest.length(); i++) {
            count[largest.charAt(i) - 'a']++;
        }

        String targetSuffix = target.substring(start);

        return largest.toString().compareTo(targetSuffix) > 0;
    }
}
