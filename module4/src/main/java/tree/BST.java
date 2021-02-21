package tree;

public class BST<T extends Comparable<T>> {

    private class Node {

        T value;
        Node left, right, parent;
        int count;
        int sum;

        public Node(T value) {
            this.value = value;
            count = 1;
            sum = (Integer) value;
        }
    }

    private Node root;
    private int size;

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            add(root, value);
        }
    }

    private void add(Node node, T value) {
        if (value.compareTo(node.value) > 0) {
            if (node.right == null) {
                //System.out.println(value + " added to right");
                node.right = new Node(value);
                node.right.parent = node;
                update(node, value);
                size++;
            } else {
                //System.out.println(value + " right");
                add(node.right, value);
            }
        }
        if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                //System.out.println(value + " added to left");
                node.left = new Node(value);
                node.left.parent = node;
                update(node, value);
                size++;
            } else {
               // System.out.println(value + " left");
                add(node.left, value);
            }
        }
    }

    private void update(Node node, T value) {
        if (node == null) {
            return;
        }
        node.count++;
        node.sum += (Integer) value;
        update(node.parent, value);
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    public T get(int order) {
        return get(root, order);
    }

    private T get(Node node, int order) {
        // TODO: 21.02.2021 HomeWork
        return  null;
    }

    private boolean contains(Node node, T value) {
        if (node == null) {
            return false;
        }
        if (node.value.equals(value)) {
            return true;
        }
        if (value.compareTo(node.value) > 0) {
            return contains(node.right, value);
        } else {
            return contains(node.left, value);
        }
    }

    public void showTree() {
        showTree(root, "");
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        appendTree(root, s);
        return s.toString();
    }

    private void appendTree(Node node, StringBuilder appender) {
        if (node == null) {
            return;
        }
        appendTree(node.left, appender);
        appender.append(node.value).append(' ');
        appendTree(node.right, appender);
    }

    private void showTree(Node node, String prefix) {
        if (node == null) {
            return;
        }
        showTree(node.left, prefix + "-");
        System.out.printf("%s Node has value %s, has %d nodes, with subtree sum = %d\n",
                prefix, node.value, node.count, node.sum);
        showTree(node.right, prefix + "-");
    }

}
