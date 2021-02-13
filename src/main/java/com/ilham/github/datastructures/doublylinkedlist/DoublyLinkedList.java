package com.ilham.github.datastructures.doublylinkedlist;

/**
 * Doubly Linked List, but with limited functionality
 * @param <T>
 */

public class DoublyLinkedList<T extends Comparable<T>> {
    private DoublyLinkedNode<T> headNode;
    private DoublyLinkedNode<T> tailNode;
    private int size;

    public void insertStart(T data) {
        this.size++;
        if (this.headNode == null) {
            this.headNode = new DoublyLinkedNode<T>(data);
            this.tailNode = this.headNode;
            return;
        }
        DoublyLinkedNode<T> newHeadNode = new DoublyLinkedNode<T>(data);
        newHeadNode.setNextNode(this.headNode);
        this.headNode.setPreviousNode(newHeadNode);
        this.headNode = newHeadNode;
    }

    public void insertLast(T data) {
        this.size++;
        if (this.headNode == null) {
            this.headNode = new DoublyLinkedNode<T>(data);
            this.tailNode = this.headNode;
            return;
        }
        DoublyLinkedNode<T> newTailNode = new DoublyLinkedNode<T>(data);
        this.tailNode.setNextNode(newTailNode);
        newTailNode.setPreviousNode(this.tailNode);
        this.tailNode = newTailNode;
    }

    public void traverseForward() {
        if (this.headNode == null) {
            System.out.println("No nodes in this LinkedList");
            return;
        }
        DoublyLinkedNode<T> currentNode = this.headNode;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode  = currentNode.getNextNode();
        }
        System.out.println();
    }

    public void traverseBackward() {
        if (this.headNode == null) {
            System.out.println("No nodes in this LinkedList");
            return;
        }
        DoublyLinkedNode<T> currentNode = this.tailNode;
        while (currentNode != null) {
            System.out.print(currentNode);
            currentNode  = currentNode.getPreviousNode();
        }
        System.out.println();
    }
}
