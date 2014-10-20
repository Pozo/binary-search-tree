package com.prezi.collection;

import java.util.Random;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class Node<T extends Comparable<? super T>> {
        private Node<T> leftNode;
        private Node<T> rightNode;

        private final T value;

        public Node(T value) {
            this.value = value;
        }
        public void insert(Node newNode) {
            if (newNode.getValue().compareTo(value) > 0) {
                setRightNode(newNode);
            } else {
                setLeftNode(newNode);
            }
        }

        private void setLeftNode(Node newNode) {
            if(leftNode==null) {
                leftNode = newNode;
            } else {
                leftNode.insert(newNode);
            }
        }

        private void setRightNode(Node newNode) {
            if(rightNode==null) {
                rightNode = newNode;
            } else {
                rightNode.insert(newNode);
            }
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{"+ value +
                    ", ["+ leftNode +
                    "," + rightNode +"]}";
        }
    }
	private Node<T> root;
	
	public BinarySearchTree() {
		
	}
    public void add(T node) {
        if(root == null) {
            root = new Node<T>(node);
        } else {
            root.insert(new Node<T>(node));
        }
    }
    /** TODO implement*/
    public T lookup(T value) {
        return null;
    }
    /** TODO implement*/
    public int min() {
        return 0;
    }
    /** TODO implement*/
    public int max() {
        return 0;
    }
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}