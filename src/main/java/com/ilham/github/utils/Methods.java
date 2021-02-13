package com.ilham.github.utils;

import com.ilham.github.datastructures.doublylinkedlist.DoublyLinkedList;
import com.ilham.github.datastructures.linkedlist.LinkedList;
import com.ilham.github.datastructures.queue.Queue;
import com.ilham.github.datastructures.stack.Stack;

public class Methods {
    public static void testQueue() {
        Queue<Integer> queue = new Queue<Integer>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.traverseForward();

        System.out.println(queue.dequeue());

        queue.traverseForward();

        System.out.println(queue.dequeue());

        queue.traverseForward();

        System.out.println(queue.peek());

        queue.traverseForward();

        System.out.println(queue.dequeue());

        queue.traverseForward();
    }

    public static void testStack() {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.traverse();

        System.out.println(stack.peek());

        stack.traverse();

        System.out.println(stack.pop());

        stack.traverse();

        System.out.println(stack.pop());

        stack.traverse();
        System.out.println(stack.getSize());
    }

    public static void testDoublyLinkedList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.traverseForward();
        list.traverseBackward();

        list.insertStart(-1);
        list.insertStart(-2);

        list.traverseForward();
        list.traverseBackward();

        list.insertLast(6);

        list.traverseForward();
        list.traverseBackward();
    }

    public static void testLinkedList() {
        LinkedList<String> list = new LinkedList<String>();

        list.insert("Adam");
        list.insert("Ana");
        list.insert("Daniel");

        list.traverse();
        System.out.println(list.size());

        list.remove("Ana");
        list.traverse();
        System.out.println(list.size());

        list.remove("Adam");
        list.traverse();
        System.out.println(list.size());

        list.remove("Daniel");
        list.traverse();
        System.out.println(list.size());
    }
}
