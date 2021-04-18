package dictionary.helper.naive;

import java.util.List;

import algorithms.string.naive.NaiveSearcher;
import dictionary.helper.DictionaryHelper;

public class NaiveDictionaryHelper implements DictionaryHelper {
    private NaiveSearcher dataStore = new NaiveSearcher();

    @Override
    public boolean insert(String word) {
        return dataStore.insert(word);
    }

    @Override
    public boolean search(String word) {
        return dataStore.search(word);
    }

    @Override
    public boolean delete(String word) {
        return dataStore.delete(word);
    }

    @Override
    public List<String> autoSuggest(String prefix) {
        return dataStore.autoSuggest(prefix);
    }

    @Override
    public List<String> autoCorrect(String word) {
        return dataStore.autoCorrect(word);
    }
}
