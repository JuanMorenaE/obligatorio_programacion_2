package TADs.Queue;

public class QueueNode<T>{
    T value;
    QueueNode<T> next;

    public QueueNode(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setNext(QueueNode<T> next){
        this.next = next;
    }

    public QueueNode<T> getNext(){
        return this.next;
    }
}
