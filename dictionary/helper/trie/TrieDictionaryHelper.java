package dictionary.helper.trie;

import dictionary.helper.DictionaryHelper;

import java.util.List;

import algorithms.string.trie.Trie;

public class TrieDictionaryHelper implements DictionaryHelper {

    private Trie dataTrie = new Trie();

    @Override
    public boolean insert(String word) {
        return dataTrie.insert(word);
    }

    @Override
    public boolean search(String word) {
        return dataTrie.search(word);
    }

    @Override
    public boolean delete(String word) {
        return dataTrie.delete(word);
    }

    @Override
    public List<String> autoSuggest(String prefix) {
        return dataTrie.autoSuggest(prefix);
    }

    @Override
    public List<String> autoCorrect(String word) {
        return dataTrie.autoCorrect(word);
    }
}
