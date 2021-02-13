package com.ilham.github.datastructures.binarysearchtree;

import com.ilham.github.datastructures.binarysearchtree.model.TreeNode;

/**
 * Basic Binary Search Tree Implementation.
 * @param <T>
 */

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> rootNode;

    public T getMax() {
        if (this.rootNode == null) {
            System.out.println("There are no values in this BST, returning null");
            return null;
        }

        TreeNode<T> currentNode = this.rootNode;
        while (currentNode.getRightNode() != null) {
            currentNode = currentNode.getRightNode();
        }

        return currentNode.getData();
    }

    public T getMin() {
        if (this.rootNode == null) {
            System.out.println("There are no values in this BST, returning null");
            return null;
        }

        TreeNode<T> currentNode = this.rootNode;
        while (currentNode.getLeftNode() != null) {
            currentNode = currentNode.getLeftNode();
        }

        return currentNode.getData();
    }

    public void insert(T data) {
        if (this.rootNode == null) {
            this.rootNode = new TreeNode<T>(data);
            return;
        }

        TreeNode<T> parentNode = null;
        TreeNode<T> currentNode = rootNode;

        while (currentNode != null) {
            parentNode = currentNode;
            if (data.compareTo(currentNode.getData()) > 0) {
                currentNode = currentNode.getRightNode();
            }
            else {
                currentNode = currentNode.getLeftNode();
            }
        }

        TreeNode<T> newNode = new TreeNode<T>(data);

        if (data.compareTo(parentNode.getData()) > 0) {
            parentNode.setRightNode(newNode);
        }
        else {
            parentNode.setLeftNode(newNode);
        }

        newNode.setParentNode(parentNode);
    }

    private TreeNode<T> getPredecessor(TreeNode<T> node) {
        if (node.getRightNode() != null) {
            return getPredecessor(node.getRightNode());
        }

        return node;
    }

    public void traversal() {
        traversal(rootNode);
        System.out.println();
    }

    private void traversal(TreeNode node) {
        if (node == null) return;

        traversal(node.getLeftNode());
        System.out.print(node);
        traversal(node.getRightNode());
    }
}
