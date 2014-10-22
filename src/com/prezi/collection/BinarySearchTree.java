package com.prezi.collection;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class Node<T extends Comparable<? super T>> {
        private Node<T> leftNode;
        private Node<T> rightNode;

        private final T value;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
        public Node<T> getRightNode() {
            return rightNode;
        }
        public Node<T> getLeftNode() {
            return leftNode;
        }
        public boolean rightNodeIsExists() {
            return rightNode != null;
        }
        public boolean leftNodeIsExists() {
            return leftNode != null;
        }
        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }
        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
        @Override
        public String toString() {
            return "{"+ value +
                    ", ["+ leftNode + "," + rightNode +"]" +
                    "}";
        }
    }

    public static final String SEPARATOR = ",";

    private Node<T> root;
	
	public BinarySearchTree() {
		
	}
    public void add(T value) {
        if(root == null) {
            root = new Node<T>(value);
        } else {
            add(root, new Node<T>(value));
        }
    }
    private void add(Node<T> parentNode, Node<T> newNode) {
        if(newValueIsGreaterThanCurrent(parentNode, newNode)) {
            if(parentNode.rightNodeIsExists()) {
                add(parentNode.getRightNode(), newNode);
            } else {
                parentNode.setRightNode(newNode);
            }
        } else if(newValueLessThanCurrent(parentNode, newNode)) {
            if(parentNode.leftNodeIsExists()) {
                add(parentNode.getLeftNode(), newNode);
            } else {
                parentNode.setLeftNode(newNode);
            }
        } else {
            // duplicated entry not allowed
        }
    }
    private boolean newValueLessThanCurrent(Node<T> node, Node<T> newNode) {
        return newValueLessThanCurrent(node,newNode.getValue());
    }
    private boolean newValueIsGreaterThanCurrent(Node<T> node, Node<T> newNode) {
        return newValueIsGreaterThanCurrent(node, newNode.getValue());
    }
    private boolean newValueLessThanCurrent(Node<T> node, T newValue) {
        return newValue.compareTo(node.getValue()) < 0;
    }
    private boolean newValueIsGreaterThanCurrent(Node<T> node, T newValue) {
        return newValue.compareTo(node.getValue()) > 0;
    }
    public boolean lookup(T value) {
        if (root == null) {
            return(false);
        } else {
            if(lookup(root, value) != null) {
                return true;
            } else {
                return false;
            }
        }
    }
    private Node<T> lookup(Node<T> node, T nodeValue) {
        if(nodeValue == null) {
            return null;
        }
        if(nodeValue.equals(node.getValue())) {
            return node;
        }
        if(newValueIsGreaterThanCurrent(node, nodeValue)) {
            if(node.rightNodeIsExists()) {
                return lookup(node.getRightNode(),nodeValue);
            } else {
                return null;
            }
        } else if(newValueLessThanCurrent(node, nodeValue)) {
            if(node.leftNodeIsExists()) {
                return lookup(node.getLeftNode(), nodeValue);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    /*
    public boolean remove(T value) {
        if (root == null) {
            return false;
        } else {
            Node<T> node;

            if((node = root.lookup(value)) != null) {
                return node.remove();
            } else {
                return false;
            }
        }
    }

    public boolean remove(T value) {
        if (value == null) {
            return false;
        }
        if (value.compareTo(getValue()) > 0) {
            if (rightNodeIsExists() && value.equals(rightNode.getValue())) {
                System.out.println("getRightNode() = " + getRightNode().getRightNode());
                setRightNode(getRightNode().getRightNode());
                setRightNode(null);

                return true;
            } else {
                return ((rightNodeIsExists()) ? rightNode.remove(value) : false);
            }
        } else {
            if (leftNodeIsExists() && value.equals(leftNode.getValue())) {
                System.out.println("leftNode = " + getLeftNode());
                setLeftNode(getLeftNode().getLeftNode());
                setLeftNode(null);

                return true;
            } else {
                return ((leftNodeIsExists()) ? leftNode.remove(value) : false);
            }
        }
    }
    */
    public int size() {
        if (root == null) {
            return 0;
        } else {
            return size(root);
        }
    }
    private int size(Node<T> node) {
        return 1
                + ((node.leftNodeIsExists())? size(node.getLeftNode()) : 0)
                + ((node.rightNodeIsExists())? size(node.getRightNode()) : 0);
    }
    public int minDepth() {
        if (root == null) {
            return 0;
        } else {
            return minDepth(root);
        }
    }
    private int minDepth(Node<T> node) {
        int lDepth = ((node.leftNodeIsExists())? minDepth(node.getLeftNode()) : 0);
        int rDepth = ((node.rightNodeIsExists())? minDepth(node.getRightNode()) : 0);

        return 1 + Math.min(lDepth, rDepth);
    }
    public int maxDepth() {
        if (root == null) {
            return 0;
        } else {
            return maxDepth(root);
        }
    }
    public int maxDepth(Node<T> node) {
        int lDepth = ((node.leftNodeIsExists())? maxDepth(node.getLeftNode()) : 0);
        int rDepth = ((node.rightNodeIsExists())? maxDepth(node.getRightNode()) : 0);

        return(1 +
                Math.max(lDepth, rDepth));
    }
    public Node<T> findMin(Node<T> node) {
        if(node.getLeftNode() == null) {
            return node;
        } else {
            return findMin(node.getLeftNode());
        }
    }
    public void printPostorder() {
        if (root == null) {
            return;
        } else {
            printPostorder(root);
        }
    }
    public void printPostorder(Node<T> node) {
        if(node.leftNodeIsExists()) {
            printPostorder(node.getLeftNode());
        }
        if(node.rightNodeIsExists()) {
            printPostorder(node.getRightNode());
        }
        System.out.print(node.getValue() + SEPARATOR);
    }
    public void print() {
        if (root == null) {
            return;
        } else {
            print(root);
        }
    }
    public void print(Node<T> node) {
        System.out.print(node.getValue() + SEPARATOR);

        if(node.leftNodeIsExists()) {
            print(node.getLeftNode());
        }
        if(node.rightNodeIsExists()) {
            print(node.getRightNode());
        }
    }
    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                '}';
    }
}