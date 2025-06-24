package TADs.Queue;

public class PriorityQueueNode<T>{
    T value;
    PriorityQueueNode<T> next;
    double priority;

    public PriorityQueueNode(T value, double priority){
        this.value = value;
        this.priority = priority;
    }

    public double getPriority(){
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
