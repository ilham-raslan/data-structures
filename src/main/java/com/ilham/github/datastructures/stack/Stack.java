package com.ilham.github.datastructures.stack;

import com.ilham.github.datastructures.linkedlist.model.Node;

/**
 * This is a stack implementation that uses the Node class of the linkedlist package
 * @param <T>
 */

public class Stack<T extends Comparable<T>> {
    private Node<T> head;
    private int size;

    public T pop() {
        this.size--;
        if (this.head == null) {
            return null;
        }
        T data = this.head.getData();
        this.head = this.head.getNextNode();
        return data;
    }

    public T peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.getData();
    }

    public void push(T data) {
        this.size++;
        if (this.head == null) {
            this.head = new Node<T>(data);
            return;
        }
        Node<T> newNode = new Node<T>(data);
        newNode.setNextNode(this.head);
        this.head = newNode;
    }

    public void traverse() {
        if (this.head == null) {
            System.out.println("No items in this stack");
            return;
        }
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    public int getSize() {
        return this.size;
    }
}
