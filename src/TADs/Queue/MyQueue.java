package TADs.Queue;

import uy.edu.um.practico3.exceptions.EmptyQueueException;

public interface MyQueue <T> {
    void enqueue (T element);
    T dequeue () throws EmptyQueueException;

    boolean isEmpty();
}
