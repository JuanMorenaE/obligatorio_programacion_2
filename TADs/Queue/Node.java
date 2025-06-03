package TADs.Queue;

public class Node <T>{
    T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node<T> getNext(){
        return this.next;
    }
}
