package algorithms.string.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {

    private int numPrefixes = 0;
    private boolean isEndOfWord = false;
    Map<Character, TrieNode> children = new HashMap<>();
    

    boolean insert(String word, int index) {
        if(index == word.length()) {
            if(isEndOfWord) return false;
            else{
                numPrefixes++;
                isEndOfWord = true;
                return true;
            }
        }
        if(children.get(word.charAt(index))== null) {
            children.put(word.charAt(index), new TrieNode());
        }
        if (children.get(word.charAt(index)).insert(word, index+1)){
            numPrefixes++;
            return true;
        }
        return false;
    }

    boolean search(String word, int index) {
        if(index == word.length()) {
            return isEndOfWord;
        }
        if(children.get(word.charAt(index))== null) {
            return false;
        }
        return children.get(word.charAt(index)).search(word, index+1);
    }

    boolean delete(String word, int index) {
        if(word.length() == index) {
            if(isEndOfWord){
                numPrefixes--;
                isEndOfWord = false;
                return true;
            }
            return false;
        }
        if(children.get(word.charAt(index))== null) {
            return false;
        }
        if (children.get(word.charAt(index)).delete(word, index+1)) {
            numPrefixes--;
            if(numPrefixes==0){
                children.remove(word.charAt(index));
            }
            return true;
        }
        return false;
    }
}
