package com.ilham.github.datastructures.binarysearchtree;

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

    public void remove(T data) {
        if (this.rootNode == null) {
            System.out.println("No nodes in this tree, so no removal performed");
            return;
        }

        remove(data, this.rootNode);
    }

    // Needed to refer to content a lot for this method, may want to revisit in the future
    private void remove(T data, TreeNode<T> node) {
        if (node == null) {
            return;
        }

        if (data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightNode());
        }
        else if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftNode());
        }
        else {
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                TreeNode<T> parentNode = node.getParentNode();

                if (parentNode != null && parentNode.getRightNode() == node) {
                    parentNode.setRightNode(null);
                }
                else if (parentNode != null && parentNode.getLeftNode() == node) {
                    parentNode.setLeftNode(null);
                }

                if (parentNode == null) {
                    this.rootNode = null;
                }

            }
            else if (node.getLeftNode() == null && node.getRightNode() != null) {
                TreeNode<T> parentNode = node.getParentNode();
                if (parentNode != null && parentNode.getRightNode() == node) {
                    parentNode.setRightNode(node.getRightNode());
                }
                else if (parentNode != null && parentNode.getLeftNode() == node) {
                    parentNode.setLeftNode(node.getRightNode());
                }

                if (parentNode == null) {
                    this.rootNode = node.getRightNode();
                }

                node.getRightNode().setParentNode(parentNode);
            }
            else if (node.getLeftNode() != null && node.getRightNode() == null) {
                TreeNode<T> parentNode = node.getParentNode();
                if (parentNode != null && parentNode.getRightNode() == node) {
                    parentNode.setRightNode(node.getLeftNode());
                }
                else if (parentNode != null && parentNode.getLeftNode() == node) {
                    parentNode.setLeftNode(node.getLeftNode());
                }

                if (parentNode == null) {
                    this.rootNode = node.getLeftNode();
                }

                node.getLeftNode().setParentNode(parentNode);
                node = null;
            }
            else {
                TreeNode<T> predecessor = getPredecessor(node.getLeftNode());

                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                remove(data, predecessor);
            }
        }
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
