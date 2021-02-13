package com.ilham.github.datastructures.linkedlist;

import lombok.Data;

@Data
public class Node<T extends Comparable<T>> {
    private T data;
    private Node<T> nextNode;

    public Node(T data) {
        this.data = data;
    }

    public String toString() {
        return this.data.toString() + " -> ";
    }
}
