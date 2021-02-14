package lists;

public interface SamsungList<T> extends Iterable<T> {

    boolean isEmpty();
    int size();
    void add(T value);
    void add(int idx, T value);
    void addAll(SamsungList<T> list);
    boolean delete(T object);
    void deleteAll(SamsungList<T> list);
    boolean remove(int idx);
    boolean remove(int from, int to);
    T get(int idx);
    void set(int idx, T value);

}
