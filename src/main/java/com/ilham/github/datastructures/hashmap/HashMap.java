package com.ilham.github.datastructures.hashmap;

import com.ilham.github.datastructures.hashmap.model.HashObject;

import static com.ilham.github.utils.Constants.HASHMAP_CAPACITY;

public class HashMap<K extends Comparable<K>, V extends Comparable<V>> {

    private HashObject<K, V>[] array;

    public HashMap() {
        this.array = new HashObject[HASHMAP_CAPACITY];
    }

    public void put(K key, V value) {
        int index = hash(key);

        HashObject<K, V> hashObject = new HashObject<K, V>(key, value);

        HashObject<K, V> currentHashObject = this.array[index];

        if (currentHashObject == null) {
            this.array[index] = hashObject;
            return;
        }

        System.out.println("Hash collision at index " + index + " , adding value " + value + " through chaining");

        while (currentHashObject.getNextHashObject() != null) {
            currentHashObject = currentHashObject.getNextHashObject();
        }

        currentHashObject.setNextHashObject(hashObject);
    }

    public V get(K key) {
        int index = hash(key);

        HashObject<K, V> currentHashObject = this.array[index];

        while (currentHashObject != null) {
            if (key.compareTo(currentHashObject.getKey()) == 0) {
                return currentHashObject.getValue();
            }
            currentHashObject = currentHashObject.getNextHashObject();
        }

        return null;
    }

    private int hash(K key) {
        return key.hashCode() % HASHMAP_CAPACITY;
    }
}
