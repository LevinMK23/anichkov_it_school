package hash;

import java.util.Objects;

public class HashTable<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node[] data;
    private int capacity;
    private int size;
    private int maxDepth;
    private int loadFactor;

    public HashTable() {
        capacity = 3;
        data = new Node[capacity];
        loadFactor = 30;
        maxDepth = 5;
    }

    private int getIndex(T value) {
        return value.hashCode() % capacity;
    }

    public void add(T value) {
        int idx = getIndex(value);
        Node<T> node = data[idx];
        int depth = 0;
        if (node == null) {
            data[idx] = new Node<>(value);
        } else {
            while (node.next != null) {
                node = node.next;
                depth++;
            }
            node.next = new Node<>(value);
        }
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        if (capacity / maxDepth < loadFactor) {
            ensureCapacity();
        }
        size++;
    }

    private void ensureCapacity() {
        capacity = capacity * loadFactor;
        Node[] tmp = new Node[capacity];
        for (Node node : data) {
            while (node != null) {
                T value = (T) node.value;
                int idx = getIndex(value);
                Node<T> cur = tmp[idx];
                if (cur == null) {
                    tmp[idx] = new Node<>(value);
                } else {
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = new Node<>(value);
                }
                node = node.next;
            }
        }
        data = tmp;
    }

    public void remove(T value) {
        int idx = getIndex(value);
        if (data[idx] != null) {
            Node<T> node = data[idx];
            while (!node.value.equals(value)) {

            }
        }
    }

    public boolean contains(T value) {
        int idx = getIndex(value);
        Node<T> node = data[idx];
        if (node == null) {
            return false;
        } else {
            while (node != null) {
                if (Objects.equals(value, node.value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public void show() {
        for (Node node : data) {
            System.out.print(node == null ? null : "");
            while (node != null) {
                System.out.print(node.value + " ");
                node = node.next;
            }
            System.out.println();
        }
    }

}
