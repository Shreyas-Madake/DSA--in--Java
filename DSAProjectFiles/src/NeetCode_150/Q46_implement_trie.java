package NeetCode_150;
class TrieNode {
    public TrieNode[] links;
    public final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setend() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

public class Q46_implement_trie {
    private TrieNode root;

    public void Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentchar = word.charAt(i);
            if (!node.containsKey(currentchar)) {
                node.put(currentchar, new TrieNode());
            }
            node = node.get(currentchar);
        }
        node.setend();
    }

    public TrieNode searchprefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentchar = word.charAt(i);
            if (node.containsKey(currentchar)) {
                node = node.get(currentchar);
            } else {
                return null;
            }
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchprefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchprefix(prefix);
        return node != null;
    }
}
