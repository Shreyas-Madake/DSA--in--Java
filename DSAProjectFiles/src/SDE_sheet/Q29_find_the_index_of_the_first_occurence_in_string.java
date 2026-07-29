package SDE_sheet;

public class Q29_find_the_index_of_the_first_occurence_in_string {
    public int strStr(String text, String pat) {
        int n = text.length();
        int m = pat.length();

        if (m > n) return -1;
        if (m == 0) return 0;

        // Base value for character set (26 for lowercase English letters)
        int BASE = 31;
        // Large prime modulus to prevent integer overflow and reduce collisions
        long MOD = 1_000_000_007L;

        // Compute BASE^(m-1) % MOD for sliding the window
        long maxWeight = 1;
        for (int i = 0; i < m - 1; i++) {
            maxWeight = (maxWeight * BASE) % MOD;
        }

        long patHash = 0;
        long textHash = 0;

        // 1. Calculate hash for the pattern and the first window of text
        for (int i = 0; i < m; i++) {
            patHash = (patHash * BASE + (pat.charAt(i) - 'a' + 1)) % MOD;
            textHash = (textHash * BASE + (text.charAt(i) - 'a' + 1)) % MOD;
        }

        // 2. Slide the window over text
        for (int i = 0; i <= n - m; i++) {
            // If hashes match, check actual substring to handle hash collision
            if (patHash == textHash) {
                if (text.substring(i, i + m).equals(pat)) {
                    return i;
                }
            }

            // Calculate rolling hash for next window
            if (i < n - m) {
                // Remove leading character
                textHash = (textHash - (text.charAt(i) - 'a' + 1) * maxWeight) % MOD;
                if (textHash < 0) textHash += MOD; // Handle negative modulo

                // Shift left and add trailing character
                textHash = (textHash * BASE + (text.charAt(i + m) - 'a' + 1)) % MOD;
            }
        }

        return -1;
    }
}
