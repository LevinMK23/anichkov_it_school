package lists;

import java.util.Iterator;

public class SamsungArrayList<T> implements SamsungList<T> {

    private Object[] data;
    private int size;
    private int capacity;

    public SamsungArrayList() {
        capacity = 5;
        data = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            Object[] tmp = new Object[capacity];
            for (int i = 0; i < size; i++) {
                tmp[i] = data[i];
            }
            data = tmp;
        }
    }

    @Override
    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    @Override
    public void add(int idx, T value) {
        ensureCapacity();
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("idx = " + idx);
        }
        for (int i = size; i > idx; i--) {
            data[i] = data[i - 1];
        }
        data[idx] = value;
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
        return remove(indexOf(object));
    }

    public int indexOf(T object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void deleteAll(SamsungList<T> list) {
        for (T t : list) {
            delete(t);
        }
    }

    @Override
    public boolean remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("idx = " + idx);
        }
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    // 1, 3 -> 1, 2, 3
    @Override
    public boolean remove(int from, int to) {
        if (from < 0 || to >= size || to < from) {
            throw new IndexOutOfBoundsException();
        }
        int cnt = to - from + 1;
        for (int i = from; i < size - cnt; i++) {
            data[i] = data[i + cnt];
        }
        size -= to - from + 1;
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("idx = " + idx);
        }
        return (T) data[idx];
    }

    @Override
    public void set(int idx, T value) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("idx = " + idx);
        }
        data[idx] = value;
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
        return new SamsungArrayListIterator();
    }

    private class SamsungArrayListIterator implements Iterator<T> {

        int position;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            return (T) data[position++];
        }
    }
}
