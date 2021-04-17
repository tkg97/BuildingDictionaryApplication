package dictionary.search.Trie;

public class Trie {
    private TrieNode root = new TrieNode();
    private int startIndex = 0;

    public boolean insert(String word) {
        return root.insert(word, startIndex);
    }

    public boolean search(String word) {
        return root.search(word, startIndex);
    }

    public boolean delete(String word) {
        return root.delete(word, startIndex);
    }
}
