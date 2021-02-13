package com.ilham.github.datastructures.doublylinkedlist;

import lombok.Data;

@Data
public class DoublyLinkedNode<T extends Comparable<T>> {
    private T val;
    private DoublyLinkedNode<T> previousNode;
    private DoublyLinkedNode<T> nextNode;

    public DoublyLinkedNode(T data) {
        this.val = data;
    }

    public String toString() {
        return this.val + " -> ";
    }
}
