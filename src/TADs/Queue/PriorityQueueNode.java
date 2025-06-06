package TADs.Queue;

public class PriorityQueueNode<T>{
    T value;
    PriorityQueueNode<T> next;
    int priority;

    public PriorityQueueNode(T value, int priority){
        this.value = value;
        this.priority = priority;
    }

    public int getPriority(){
        return this.priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setNext(PriorityQueueNode<T> next){
        this.next = next;
    }

    public PriorityQueueNode<T> getNext(){
        return this.next;
    }
}
