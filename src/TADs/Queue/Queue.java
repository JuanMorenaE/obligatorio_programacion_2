package TADs.Queue;

import TADs.exceptions.EmptyQueueException;

public class Queue<T> implements MyQueue<T> {
    QueueNode<T> first;
    int size;

    public Queue() {
    }


    public void enqueue(T element) {
        QueueNode<T> node = new QueueNode<>(element);

        if(size == 0){
            first = node;
        }else{
            QueueNode<T> currentNode = first;
            while(currentNode.getNext() != null)
                currentNode = currentNode.getNext();
            currentNode.setNext(node);
        }
        size++;
    }

    public T dequeue() throws EmptyQueueException {
        if (size == 0)
            throw new EmptyQueueException("Queue is already empty.");

        QueueNode<T> next = first.getNext();
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