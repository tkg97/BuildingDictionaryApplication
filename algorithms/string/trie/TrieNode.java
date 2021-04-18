package algorithms.string.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import algorithms.string.Pair;

class TrieNode {

    private int numPrefixes = 0;
    private int accessFrequency = 0;
    private boolean isEndOfWord = false;
    Map<Character, TrieNode> children = new HashMap<>();

    boolean insert(String word, int index) {
        if (index == word.length()) {
            if (isEndOfWord)
                return false;
            else {
                numPrefixes++;
                isEndOfWord = true;
                return true;
            }
        }
        if (children.get(word.charAt(index)) == null) {
            children.put(word.charAt(index), new TrieNode());
        }
        if (children.get(word.charAt(index)).insert(word, index + 1)) {
            numPrefixes++;
            return true;
        }
        return false;
    }

    boolean search(String word, int index) {
        if (index == word.length()) {
            if(isEndOfWord){
                accessFrequency++;
            }
            return isEndOfWord;
        }
        if (children.get(word.charAt(index)) == null) {
            return false;
        }
        return children.get(word.charAt(index)).search(word, index + 1);
    }

    boolean delete(String word, int index) {
        if (word.length() == index) {
            if (isEndOfWord) {
                numPrefixes--;
                isEndOfWord = false;
                return true;
            }
            return false;
        }
        if (children.get(word.charAt(index)) == null) {
            return false;
        }
        if (children.get(word.charAt(index)).delete(word, index + 1)) {
            numPrefixes--;
            if (numPrefixes == 0) {
                children.remove(word.charAt(index));
            }
            return true;
        }
        return false;
    }

    TrieNode getPrefixNode(String word, int index) {
        if(word.length() == index) {
            return this;
        }
        if (children.get(word.charAt(index)) == null) {
            return null;
        }
        return children.get(word.charAt(index)).getPrefixNode(word, index + 1);
    }

    List<Pair> getAllDescendentWords(String word) {
        List<Pair> descendents = new ArrayList<>();
        if (isEndOfWord) {
            descendents.add(new Pair(word, accessFrequency));
        }
        for(char c : children.keySet()) {
            String newPrefix = word + c;
            descendents.addAll(children.get(c).getAllDescendentWords(newPrefix));
        }
        return descendents;
    }
}
