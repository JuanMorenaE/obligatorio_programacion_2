package TADs.Queue;

import uy.edu.um.practico3.exceptions.EmptyQueueException;
import uy.edu.um.practico3.interfaces.MyQueue;

public class QueueChainedList<T> implements MyQueue<T> {
    Node<T> first;
    int size;

    public QueueChainedList() {
    }


    public void enqueue(T element) {
        Node<T> node = new Node<>(element);

        if(size == 0){
            first = node;
        }else{
            Node<T> currentNode = first;
            while(currentNode.getNext() != null)
                currentNode = currentNode.getNext();
            currentNode.setNext(node);
        }
        size++;
    }

    public T dequeue() throws EmptyQueueException {
        if (size == 0)
            throw new EmptyQueueException("Queue is already empty.");

        Node<T> next = first.getNext();
        T value = first.value;
        first.setValue(null);
        first = next;
        size--;

        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
