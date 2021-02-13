package com.ilham.github.datastructures.trie.model;

import lombok.Data;

import static com.ilham.github.utils.Constants.ALPHABET_SIZE;

@Data
public class TrieNode<V extends Comparable<V>> {
    private String character;
    private TrieNode<V>[] children;
    private boolean isLeaf;
    private boolean visited;
    private V value;

    public TrieNode(String character) {
        this.character = character;
        this.children = new TrieNode[ALPHABET_SIZE];
    }

    public TrieNode<V> getChild(int index) {
        return this.children[index];
    }

    public void setChild(int index, TrieNode<V> node) {
        this.children[index] = node;
    }
}
