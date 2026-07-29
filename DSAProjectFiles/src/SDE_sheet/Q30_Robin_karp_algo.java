package SDE_sheet;

public class Q30_Robin_karp_algo {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Step 1: Repeat string 'a' until its length is >= length of 'b'
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Step 2: Check if 'b' exists in 'sb' using Rabin-Karp
        if (rabinKarp(sb.toString(), b) != -1) {
            return count;
        }

        // Step 3: Append 'a' one more time to handle edge overlap
        sb.append(a);
        if (rabinKarp(sb.toString(), b) != -1) {
            return count + 1;
        }

        return -1;
    }

    // Rabin-Karp algorithm to check if 'pat' is a substring of 'text'
    private int rabinKarp(String text, String pat) {
        int n = text.length();
        int m = pat.length();

        if (m > n) return -1;

        int BASE = 31;
        long MOD = 1_000_000_007L;

        long maxWeight = 1;
        for (int i = 0; i < m - 1; i++) {
            maxWeight = (maxWeight * BASE) % MOD;
        }

        long patHash = 0;
        long textHash = 0;

        for (int i = 0; i < m; i++) {
            patHash = (patHash * BASE + (pat.charAt(i) - 'a' + 1)) % MOD;
            textHash = (textHash * BASE + (text.charAt(i) - 'a' + 1)) % MOD;
        }

        for (int i = 0; i <= n - m; i++) {
            if (patHash == textHash) {
                if (text.substring(i, i + m).equals(pat)) {
                    return i; // Found match
                }
            }

            if (i < n - m) {
                textHash = (textHash - (text.charAt(i) - 'a' + 1) * maxWeight) % MOD;
                if (textHash < 0) textHash += MOD;
                textHash = (textHash * BASE + (text.charAt(i + m) - 'a' + 1)) % MOD;
            }
        }

        return -1;
    }
}
