package pl.slemjet.trees.binary;

public class MyBinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public MyBinarySearchTree() {
    }

    public MyBinarySearchTree(T... values) {
        super();
        if (values.length > 0) {
            for (T value : values) {
                insert(value);
            }
        }
    }

    public MyBinarySearchTree(T rootValue) {
        this.root = new Node<>(rootValue);
    }

    public Node<T> getRoot() {
        return root;
    }

    public MyBinarySearchTree<T> insert(T value) {
        insertValue(root, value);
        return this;
    }

    private void insertValue(Node<T> node, T value) {
        if (node == null || value == null)
            root = new Node<>(value);
        else if (node.getValue().compareTo(value) > 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<>(value));
            } else {
                insertValue(node.getLeft(), value);
            }
        } else if (node.getValue().compareTo(value) < 0) {
            if (node.getRight() == null) {
                node.setRight(new Node<>(value));
            } else {
                insertValue(node.getRight(), value);
            }
        }
    }

    public Node<T> lookup(T value) {
        return findValue(root, value);
    }

    public void remove(T value) {
        if (value == null) {
            return;
        }

        Node<T> parentNode = null;
        Node<T> currentNode = root;
        boolean isLeftChild = false;
        while (currentNode != null) {
            if (value.equals(currentNode.getValue())) {
                // found node
                Node<T> nodeToSet;
                if (parentNode == null) {
                    // delete root node
                    var rightSubTree = root.getRight();
                    var leftSubTree = root.getLeft();
                    if (rightSubTree != null) {
                        Node closestLeaf = getClosestLeaf(rightSubTree, false);
                        closestLeaf.setLeft(leftSubTree);
                        this.root = rightSubTree;
                    } else if (leftSubTree != null) {
                        this.root = leftSubTree;
                    }
                    return;
                } else if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                    //is leaf
                    nodeToSet = null;
                } else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
                    // has only right child -> simply re-base
                    nodeToSet = currentNode.getRight();
                } else if (currentNode.getRight() == null && currentNode.getLeft() != null) {
                    // has only left child -> simply re-base
                    nodeToSet = currentNode.getLeft();
                } else {
                    // check if is closest leaf
                    nodeToSet = getClosestLeaf(currentNode, isLeftChild);
                    var newRightNode = currentNode.getRight();
                    nodeToSet.setRight(nodeToSet.getValue().compareTo(newRightNode.getValue()) != 0 ? newRightNode : null);
                    var newLeftNode = currentNode.getLeft();
                    nodeToSet.setLeft(nodeToSet.getValue().compareTo(newLeftNode.getValue()) != 0 ? newLeftNode : null);
                }
                if (isLeftChild) {
                    parentNode.setLeft(nodeToSet);
                } else {
                    parentNode.setRight(nodeToSet);
                }
                return;
            } else {
                parentNode = currentNode;
                if (value.compareTo(currentNode.getValue()) > 0) {
                    // go right
                    currentNode = currentNode.getRight();
                    isLeftChild = false;
                } else {
                    // go left
                    currentNode = currentNode.getLeft();
                    isLeftChild = true;
                }
            }
        }
    }

    private Node getClosestLeaf(Node<T> currentNode, boolean searchToRight) {
        if (currentNode != null) {
            if (searchToRight) {
                if (currentNode.getRight() == null) {
                    return currentNode;
                } else return getClosestLeaf(currentNode.getRight(), true);
            } else {
                if (currentNode.getLeft() == null) {
                    return currentNode;
                } else return getClosestLeaf(currentNode.getLeft(), false);
            }
        }
        return null;
    }

    private Node<T> findValue(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        if (value.equals(node.getValue())) {
            return node;
        } else {
            return findValue(value.compareTo(node.getValue()) > 0 ? node.getRight() : node.getLeft(), value);
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

    public class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return (left != null ? left.toString() : "") + ":" + value + ":" + (right != null ? right.toString() : "");
        }
    }

}
