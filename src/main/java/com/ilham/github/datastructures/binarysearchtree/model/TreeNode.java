package com.ilham.github.datastructures.binarysearchtree.model;

import lombok.Data;

@Data
public class TreeNode<T extends Comparable<T>> {
    private T data;
    private TreeNode<T> leftNode;
    private TreeNode<T> rightNode;
    private TreeNode<T> parentNode;

    public TreeNode(T data) {
        this.data = data;
    }

    public String toString() {
        return this.data + " -> ";
    }
}
