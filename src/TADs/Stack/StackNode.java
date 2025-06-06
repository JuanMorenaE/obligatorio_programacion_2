package TADs.Stack;

public class StackNode<T>{
    T data;
    StackNode<T> next;

    public StackNode(T data) {
        this.data = data;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
