package dictionary;

import java.util.List;

import dictionary.helper.DictionaryHelper;

public class Dictionary {

    private DictionaryHelper helper;

    public static enum Operation {
        INSERT, SEARCH, DELETE, AUTOSUGGEST, AUTOCORRECT;

        public static Operation parse(String str) {
            return valueOf(str.toUpperCase());
        }
    }

    public Dictionary(DictionaryHelper helper) {
        this.helper = helper;
    }

    public boolean insert(String word) {
        return helper.insert(word);
    }

    public boolean search(String word) {
        return helper.search(word);
    }

    public boolean delete(String word) {
        return helper.delete(word);
    }

    public List<String> autoSuggest(String prefix) {
        return helper.autoSuggest(prefix);
    }

    public List<String> autoCorrect(String word) {
        return helper.autoCorrect(word);
    }
}
