package module2.lesson1;

public class IntList {

    private int[] data;
    private int length;
    private int capacity;

    public IntList() {
        length = 0;
        capacity = 15;
        data = new int[capacity];
    }

    public int size() {
        return length;
    }

    public int get(int index) {
        return data[index];
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    public void add(int value) {
        if (length == capacity) {
            reallocate();
        }
        data[length] = value;
        length++;
    }

    private void reallocate() {
        capacity *= 2;
        int[] tmp = new int[capacity];
        if (length >= 0) {
            System.arraycopy(data, 0, tmp, 0, length);
        }
        data = tmp;
    }

    public void remove() {
        length--;
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
