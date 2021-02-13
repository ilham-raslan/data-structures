package com.ilham.github.datastructures.linkedlist;

import com.ilham.github.datastructures.linkedlist.model.List;
import com.ilham.github.datastructures.linkedlist.model.Node;

/**
 * LinkedList implementation
 * @param <T>
 */

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> head;
    private int size;

    public void insert(T data) {
        this.size++;
        if (this.head == null) {
            this.head = new Node<T>(data);
            return;
        }

        Node<T> currentNode = this.head;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }
        currentNode.setNextNode(new Node<T>(data));
    }

    public void remove(T data) {
        if (this.head == null) {
            System.out.println("Data not found, not removing anything");
            return;
        }

        Node<T> currentNode = this.head;
        if (this.head.getData().compareTo(data) == 0) {
            this.head = currentNode.getNextNode();
            currentNode.setNextNode(null);
            this.size--;
            return;
        }

        currentNode = currentNode.getNextNode();
        Node<T> previousNode = this.head;

        while (currentNode != null) {
            if (currentNode.getData().compareTo(data) == 0) {
                if (currentNode.getNextNode() != null) {
                    previousNode.setNextNode(currentNode.getNextNode());
                    currentNode.setNextNode(null);
                }
                else {
                    previousNode.setNextNode(null);
                }
                this.size--;
                return;
            }
            previousNode = previousNode.getNextNode();
            currentNode = currentNode.getNextNode();
        }

        System.out.println("Data not found, not removing anything");
    }

    public void traverse() {
        if (this.head == null) {
            System.out.println("There is nothing in this LinkedList");
            return;
        }
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode = currentNode.getNextNode();
        }
        System.out.println();
    }

    public int size() {
        return this.size;
    }
}
