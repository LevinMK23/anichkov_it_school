package lists;

import java.util.Iterator;

public class SamsungLinkedList<T> implements SamsungList<T> {

    private Node head, tail;
    private int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T value) {
        if (size == 0) {
            head = tail = new Node(value);
        } else {
            tail.addLast(new Node(value));
        }
        size++;
    }

    @Override
    public void add(int idx, T value) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("idx = " + idx);
        }
        if (idx == 0) {
            head.addFirst(new Node(value));
        } else if (idx == size) {
            tail.addLast(new Node(value));
        } else {
            Node current = head;
            for (int i = 0; i < idx - 1; i++) {
                current = current.next;
            }
            current.addBetween(current, current.next, new Node(value));
        }
        size++;
    }

    @Override
    public void addAll(SamsungList<T> list) {
        for (T t : list) {
            add(t);
        }
    }

    @Override
    public boolean delete(T object) {

        return false;
    }

    @Override
    public void deleteAll(SamsungList<T> list) {

    }

    @Override
    public boolean remove(int idx) {
        return false;
    }

    @Override
    public boolean remove(int from, int to) {
        return false;
    }

    @Override
    public T get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("idx = " + idx);
        }
        Node current = head;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void set(int idx, T value) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("idx = " + idx);
        }
        Node current = head;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }
        current.value = value;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (T item : this) {
            list.append(item).append(" ");
        }
        return list.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new SamsungLinkedListIterator();
    }

    private class SamsungLinkedListIterator implements Iterator<T> {

        private Node ptr = head;

        @Override
        public boolean hasNext() {
            return ptr != null;
        }

        @Override
        public T next() {
            T value = ptr.value;
            ptr = ptr.next;
            return value;
        }
    }

    private class Node {

        private T value;
        private Node next, prev;

        public Node(T value) {
            this.value = value;
        }

        public void addLast(Node newNode) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }

        public void addFirst(Node newNode) {
            head.prev = newNode;
            newNode.next = head;
            head = head.prev;
        }

        public void addBetween(Node left, Node right, Node newNode) {
            left.next = newNode;
            right.prev = newNode;
            newNode.next = right;
            newNode.prev = left;
        }
    }
}
