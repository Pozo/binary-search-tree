package com.prezi.collection;

public class BinarySearchTree<T extends Comparable<? super T>> {
    public static class Node<T extends Comparable<? super T>> {
        private Node<T> leftNode;
        private Node<T> rightNode;

        private T value;

        public Node(T value) {
            this.value = value;
        }
        public void setValue(T value) {
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
        public String serialize() {
            return "{"+ value + " ["+ ((leftNode == null)?"null":leftNode.serialize()) + "," + ((rightNode == null)?"null":rightNode.serialize()) +"]}";
        }
    }

    public static final String SEPARATOR = ",";

    private Node<T> root;
	
	public BinarySearchTree() {
		
	}
    public void add(T value) {
        if(value == null) {
            return;
        }
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
    private void setRootNode(Node<T> root) {
        this.root = root;
    }
    private boolean newValueLessThanCurrent(Node<T> node, Node<T> newNode) {
        return newValueLessThanCurrent(node,newNode.getValue());
    }
    private boolean newValueIsGreaterThanCurrent(Node<T> node, Node<T> newNode) {
        return newValueIsGreaterThanCurrent(node, newNode.getValue());
    }
    private boolean newValueLessThanCurrent(Node<T> node, T newValue) {
        if(node == null) {
            return false;
        }
        return newValue.compareTo(node.getValue()) < 0;
    }
    private boolean newValueIsGreaterThanCurrent(Node<T> node, T newValue) {
        if(node == null) {
            return false;
        }
        return newValue.compareTo(node.getValue()) > 0;
    }
    public boolean lookup(T value) {
        if (root == null) {
            return(false);
        } else {
            return lookup(root, value);
        }
    }
    private boolean lookup(Node<T> node, T nodeValue) {
        if(node == null || nodeValue == null) {
            return false;
        }
        if(nodeValue.equals(node.getValue())) {
            return true;
        }
        if(newValueIsGreaterThanCurrent(node, nodeValue)) {
            return lookup(node.getRightNode(),nodeValue);
        } else if(newValueLessThanCurrent(node, nodeValue)) {
            return lookup(node.getLeftNode(), nodeValue);
        } else {
            return false;
        }
    }

    public boolean remove(T value) {
        if (root == null) {
            return false;
        } else {
            return remove(null, root, value);
        }
    }
    private boolean remove(Node<T> parent, Node<T> node,T nodeValue) {
        if(node == null || nodeValue == null) {
            return false;
        }
        /* http://www.algolist.net/Data_structures/Binary_search_tree/Removal */
        if(newValueIsGreaterThanCurrent(node, nodeValue)) {
            return remove(node, node.getRightNode(),nodeValue);
        } else if(newValueLessThanCurrent(node, nodeValue)) {
            return remove(node, node.getLeftNode(), nodeValue);
        } else {
            return doRemove(parent, node, nodeValue);
        }
    }

    private boolean doRemove(Node<T> parent, Node<T> node, T nodeValue) {
        if(parent == null || (node.rightNodeIsExists() && node.leftNodeIsExists())) {
            T value = findMin(node.getRightNode()).getValue();
            System.out.println("value = " + value);
            node.setValue(value);
            remove(node, node.getRightNode(), value);
        }else if(parent.rightNodeIsExists() && parent.getRightNode().equals(node)) {
            parent.setRightNode(node.getRightNode());
        } else if (parent.leftNodeIsExists() && parent.getLeftNode().equals(node)) {

            parent.setLeftNode(node.getLeftNode());
        }
        return true;
    }

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
        if(node != null && node.getLeftNode() == null) {
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
    public String serialize() {
        if (root == null) {
            return "";
        } else {
            return root.serialize();
        }
    }

    public static <T extends Comparable<? super T>> BinarySearchTree deserialize(String string) {
        if (string == null) {
            return null;
        }
        BinarySearchTree<T> bst = new BinarySearchTree<T>();
        bst.setRootNode(parse(string));
        return bst;
    }
    private static <T extends Comparable<? super T>> Node parse(String string) {
        if (string == null) {
            return null;
        }
        String removeFirst = string.replaceFirst("\\[", "");
        StringBuilder builder = new StringBuilder(removeFirst);
        int start = removeFirst.lastIndexOf("]");
        builder.replace(start, start + 1, "");
        String nodeValueAndChildren = builder.toString();

        String[] leftRightNodeValue = nodeValueAndChildren.split(",",2);
        String nodeValue = (String) leftRightNodeValue[0];
        String childNodeValues = leftRightNodeValue[1];

        BinarySearchTree.Node<String> node = new BinarySearchTree.Node<String>(nodeValue);

        if(childNodeValues.startsWith("[")) {
            int leftBracket = 0;
            int rightBracket = 0;

            for (int i = 0;i<childNodeValues.length();i++) {
                if(Character.valueOf(childNodeValues.charAt(i)).equals('[')) {
                    leftBracket++;
                } else if(Character.valueOf(childNodeValues.charAt(i)).equals(']')) {
                    rightBracket++;
                }
                if(leftBracket == rightBracket) {
                    String leftNode = childNodeValues.substring(0,i+1);
                    String right = childNodeValues.substring(i+2,childNodeValues.length());

                    if(!right.equals("null")) {
                        node.setRightNode(parse(right));
                    }
                    if(!leftNode.equals("null")) {
                        node.setLeftNode(parse(leftNode));
                    }

                    break;
                }
            }

        } else {
            String[] keyLeftRightNodes = childNodeValues.split(",", 2);

            if(!keyLeftRightNodes[1].equals("null")) {
                node.setRightNode(parse(keyLeftRightNodes[1]));
            }
        }
        return node;
    }
}