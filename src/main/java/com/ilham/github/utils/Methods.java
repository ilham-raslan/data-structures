package com.ilham.github.utils;

import com.ilham.github.datastructures.binarysearchtree.BinarySearchTree;
import com.ilham.github.datastructures.doublylinkedlist.DoublyLinkedList;
import com.ilham.github.datastructures.hashmap.HashMap;
import com.ilham.github.datastructures.linkedlist.LinkedList;
import com.ilham.github.datastructures.queue.Queue;
import com.ilham.github.datastructures.stack.Stack;
import com.ilham.github.datastructures.trie.Trie;

public class Methods {
    public static void testTrie() {
        Trie<Integer> trie = new Trie<Integer>();

        trie.insert("adam", 1);
        trie.insert("apple", 2);
        trie.insert("adama", 3);
        trie.insert("antidote", 4);
        trie.insert("elizabeth", 10);
        trie.insert("archery", 12);
        trie.insert("fish", 3);
        trie.insert("ball", 4);
        trie.insert("alien", 5);
        trie.insert("amazing", 6);

        System.out.println(trie.search("adam"));
        System.out.println(trie.search("aim"));
        System.out.println(trie.search("antidote"));
        System.out.println(trie.search("anecdote"));
        System.out.println(trie.search("fish"));
        System.out.println(trie.search("ball"));

        System.out.println(trie.get("elizabeth"));

        System.out.println(trie.autocomplete("a"));

        System.out.println(trie.sort());
    }

    public static void testHashMap() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);
        map.put(6, 60);
        map.put(7, 70);
        map.put(8, 80);
        map.put(12, 120);
        map.put(30, 300);
        map.put(47, 470);
        map.put(65, 650);

        System.out.println(map.get(65));
    }

    public static void testBinarySearchTree() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.insert(3);
        bst.insert(1);
        bst.insert(2);
        bst.insert(4);
        bst.insert(5);
        bst.insert(10);
        bst.insert(8);
        bst.insert(7);
        bst.insert(6);

        bst.traversal();

        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
    }

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
