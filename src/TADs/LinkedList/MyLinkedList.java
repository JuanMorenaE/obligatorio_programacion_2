package TADs.LinkedList;

public interface MyLinkedList<T> {
    public void add(T value);

    public void remove(int position);

    public T get(int position);
}