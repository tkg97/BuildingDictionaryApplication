package dictionary;

import dictionary.helper.DictionaryHelper;

public class Dictionary {

    private DictionaryHelper helper;

    public static enum Operation {
        INSERT, SEARCH, DELETE, EXIT;

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
}
