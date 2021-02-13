package com.ilham.github;

import com.ilham.github.datastructures.binarysearchtree.BinarySearchTree;

import static com.ilham.github.utils.Methods.testQueue;

public class App {
    public static void main(String[] args) {
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

        bst.remove(10);

        bst.traversal();

        bst.remove(3);

        bst.traversal();
    }
}
