package com.ilham.github.datastructures.hashmap.model;

import lombok.Data;

@Data
public class HashObject<K extends Comparable<K>, V extends Comparable<V>> {
    private K key;
    private V value;
    private HashObject<K, V> nextHashObject;

    public HashObject(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
