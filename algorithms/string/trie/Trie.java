package algorithms.string.trie;

import java.util.ArrayList;
import java.util.List;

import algorithms.find.SortFinder;
import algorithms.string.Pair;
import algorithms.string.PairComparator;
import algorithms.string.SearchDAOInterface;

public class Trie implements SearchDAOInterface {
    private TrieNode root = new TrieNode();
    private int startIndex = 0;
    private SortFinder<Pair> finder = new SortFinder<>();
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
        List<Pair> topSuggestions = finder.getOrderedElements(allSuggestions, new PairComparator(), topNum);
        List<String> result = new ArrayList<>();
        for(Pair p : topSuggestions) {
            result.add(p.getValue());
        }
        return result;
    }

    public List<String> autoCorrect(String word) {
        throw new UnsupportedOperationException();
    }
}
