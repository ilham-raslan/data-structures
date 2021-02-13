package com.ilham.github.datastructures.queue;

import com.ilham.github.datastructures.doublylinkedlist.DoublyLinkedNode;

public class Queue<T extends Comparable<T>> {
    private DoublyLinkedNode<T> headNode;
    private DoublyLinkedNode<T> tailNode;
    private int size;

    public void enqueue(T data) {
        this.size++;
        if (this.headNode == null) {
            DoublyLinkedNode<T> newHeadNode = new DoublyLinkedNode<T>(data);
            this.headNode = newHeadNode;
            this.tailNode = this.headNode;
            return;
        }

        DoublyLinkedNode<T> newHeadNode = new DoublyLinkedNode<T>(data);
        newHeadNode.setNextNode(this.headNode);
        this.headNode.setPreviousNode(newHeadNode);
        this.headNode = newHeadNode;
    }

    public T dequeue() {
        if (this.headNode == null) {
            System.out.println("No items in queue, returning null");
            return null;
        }

        this.size--;
        T val = this.tailNode.getVal();
        DoublyLinkedNode<T> newTailNode = this.tailNode.getPreviousNode();
        newTailNode.setNextNode(null);
        this.tailNode.setPreviousNode(null);
        this.tailNode = newTailNode;
        return val;
    }

    public T peek() {
        if (this.headNode == null) {
            System.out.println("No items in queue, returning null");
            return null;
        }

        return this.tailNode.getVal();
    }

    public int getSize() {
        return this.size;
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
