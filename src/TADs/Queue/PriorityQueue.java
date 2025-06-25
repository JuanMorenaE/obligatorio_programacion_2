package TADs.Queue;

import TADs.exceptions.EmptyQueueException;

public class PriorityQueue<T> implements MyPriorityQueue<T> {
    PriorityQueueNode<T> first;
    PriorityQueueNode<T> last;
    private Integer maxSize;
    int size;

    public PriorityQueue(int maxSize){
        this.maxSize = maxSize;
    }

    public PriorityQueue(){}

    public void enqueueWithPriority(T element, double prioridad) {
        PriorityQueueNode<T> node = new PriorityQueueNode<>(element, prioridad);

        if(size == 0){
            first = last = node;
            size++;
            return;
        }

        if(maxSize != null && size == maxSize){
            if(prioridad <= last.priority)
                return;

            if(size == 1){
                first = last = null;
            }else{
                last.getPrevious().setNext(null);
                last = last.getPrevious();
            }
            size--;
        }

        if(first.priority < prioridad){
            node.setNext(first);
            first.setPrevious(node);
            first = node;
        }else{
            PriorityQueueNode<T> currentNode = first;
            while(currentNode.getNext() != null && currentNode.getNext().priority >= prioridad)
                currentNode = currentNode.getNext();

            node.setNext(currentNode.getNext());
            node.setPrevious(currentNode);

            if(currentNode.getNext() == null)
                last = node;
            else
                currentNode.getNext().setPrevious(node);

            currentNode.setNext(node);
        }

        size++;
    }

    public void enqueue(T element) {
        PriorityQueueNode<T> node = new PriorityQueueNode<>(element, 0);

        if(size == 0)
            first = node;
        else
            last.setNext(node);

        System.out.println("Added: '" + element + "' with priority: 0");
        last = node;
        size++;
    }

    public T dequeue() throws EmptyQueueException {
        if(size == 0)
            throw new EmptyQueueException("Queue is already empty.");

        if(last == first)
            last = null;

        PriorityQueueNode<T> next = first.getNext();
        T value = first.value;
        first.setValue(null);
        first = next;
        size--;

        return value;
    }

    public T removeLast(){
        PriorityQueueNode<T> current= first;
        if (size == 1){
            T value = first.value;
            first = null;
            last = null;
            size--;
            return value;
        }

        for (int i = 0; i < size-2; i++) {
            current= current.getNext();
        }
        PriorityQueueNode<T> next = current.getNext();
        T value = next.value;
        current.setNext(null);
        last = current;
        size--;

        return value;
    }
    public T getFirst(){
        return first.value;
    }
    public T getLast(){
        return last.value;
    }
    public int size(){
        return size;
    }



    public boolean isEmpty() {
        return size == 0;
    }
}
