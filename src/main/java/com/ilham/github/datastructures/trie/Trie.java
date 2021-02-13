package com.ilham.github.datastructures.trie;

import com.ilham.github.datastructures.trie.model.TrieNode;

import java.util.ArrayList;
import java.util.List;

import static com.ilham.github.utils.Constants.ALPHABET_SIZE;

/**
 * Basic implementation of a Trie that only works with lower case characters
 */

public class Trie<V extends Comparable<V>> {
    private TrieNode<V> root;

    public Trie() {
        this.root = new TrieNode<V>("");
    }

    public void insert(String key, V value) {
        TrieNode<V> tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';

            if (tempNode.getChild(asciiIndex) == null) {
                TrieNode<V> newNode = new TrieNode<V>(String.valueOf(c));
                tempNode.setChild(asciiIndex, newNode);
                tempNode = newNode;
            }
            else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }

        tempNode.setLeaf(true);
        tempNode.setValue(value);
    }

    public boolean search(String key) {
        TrieNode tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';

            if (tempNode.getChild(asciiIndex) == null) {
                return false;
            }

            tempNode = tempNode.getChild(asciiIndex);
        }

        return tempNode.isLeaf();
    }

    public V get(String key) {
        TrieNode<V> tempNode = this.root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';

            if (tempNode.getChild(asciiIndex) == null) {
                return null;
            }

            tempNode = tempNode.getChild(asciiIndex);
        }

        return tempNode.getValue();
    }

    public List<String> autocomplete(String prefix) {
        List<String> list = new ArrayList<String>();
        TrieNode<V> tempNode = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int asciiIndex = c - 'a';

            if (tempNode.getChild(asciiIndex) == null) {
                return list;
            }

            tempNode = tempNode.getChild(asciiIndex);
        }

        collect(tempNode, new StringBuilder(prefix), list);

        return list;
    }

    private void collect(TrieNode<V> node, StringBuilder prefixBuilder, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.isLeaf()) {
            list.add(prefixBuilder.toString());
        }

        for (TrieNode<V> childNode : node.getChildren()) {
            if (childNode == null) continue;
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefixBuilder.append(childCharacter), list);
            prefixBuilder.deleteCharAt(prefixBuilder.length() - 1);
        }
    }

    public List<String> sort() {
        return autocomplete("");
    }
}
