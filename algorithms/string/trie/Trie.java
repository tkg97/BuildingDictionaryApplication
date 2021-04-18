package algorithms.string.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import algorithms.string.Pair;
import algorithms.string.PairComparator;
import algorithms.string.SearchDAOInterface;

public class Trie implements SearchDAOInterface {
    private TrieNode root = new TrieNode();
    private int startIndex = 0;
    int topNum = 2;

    public boolean insert(String word) {
        return root.insert(word, startIndex);
    }

    public boolean search(String word) {
        return root.search(word, startIndex);
    }

    public boolean delete(String word) {
        return root.delete(word, startIndex);
    }

    public List<String> autoSuggest(String prefix) {
        TrieNode prefixNode = root.getPrefixNode(prefix, startIndex);
        List<Pair> allSuggestions = prefixNode.getAllDescendentWords(prefix);
        Collections.sort(allSuggestions, new PairComparator());
        List<String> result = new ArrayList<>();
        for(int i=0;i<topNum && i<allSuggestions.size();i++) {
            result.add(allSuggestions.get(i).getValue());
        }
        return result;
    }

    public List<String> autoCorrect(String word) {
        throw new UnsupportedOperationException();
    }
}
